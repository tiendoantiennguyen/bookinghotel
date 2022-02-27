package com.nhapmoncongnghephanmem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhapmoncongnghephanmem.converter.RoomConverter;
import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.Bill;
import com.nhapmoncongnghephanmem.entity.BillDetails;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.entity.Room;
import com.nhapmoncongnghephanmem.repository.BillRepository;
import com.nhapmoncongnghephanmem.repository.CategoryRoomRepository;
import com.nhapmoncongnghephanmem.repository.RoomRepository;
import com.nhapmoncongnghephanmem.service.IRoomService;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CategoryRoomRepository categoryRoomRepository;

	@Autowired
	private RoomConverter roomConverter;

	public ArrayList<RoomDTO> findRoom(int numberOfPeople, int numberOfPeopleInARoom, int categoryRoomID,
			String checkInDate, String checkOutDate, String specialRequest) {
		ArrayList<RoomDTO> result = new ArrayList<RoomDTO>();
		// Tim tat ca hoa don trong thoi gian do
		ArrayList<Bill> bills = billRepository.find(checkInDate, checkOutDate, "OnGoing");
		// Tim tat ca phong theo loai
		ArrayList<Room> roomCanBeRent = new ArrayList<Room>();
		ArrayList<Integer> roomCantBeRent = new ArrayList<Integer>();
		// Neu nhu co hoa don trong thoi gian do thi kiem tra xem trong hoa don co phong
		// nao de loai ra.
		if (bills.size() != 0) {
			// Tao ra danh sach nhung phong khong the thue.
			for (Bill bill : bills) {
				List<BillDetails> billDetails = bill.getBillDetails();
				for (BillDetails billDetail : billDetails) {
					Room room = billDetail.getRoom();
					if (room.getCategoryRoom().getCategoryRoomID() == categoryRoomID
							&& room.getNumberOfPeople() == numberOfPeopleInARoom) {
						if (!roomCantBeRent.contains(room.getRoomNumber())) {
							roomCantBeRent.add(room.getRoomNumber());
						}
					}
				}

			}
			// Tim ra phong co the thue.
			roomCanBeRent = roomRepository.findRoomByRoomNumberNotInAndCategoryRoomCategoryRoomIDAndNumberOfPeople(
					roomCantBeRent, categoryRoomID, numberOfPeopleInARoom);
		} else {
			roomCanBeRent = roomRepository.findRoomByCategoryRoomCategoryRoomIDAndNumberOfPeople(categoryRoomID,
					numberOfPeopleInARoom);
		}
		if (roomCanBeRent.size() != 0) {
			ArrayList<Room> roomsRent = new ArrayList<Room>();
			int numberOfRoomsNeed = numberOfPeople / numberOfPeopleInARoom;
			if (numberOfRoomsNeed % 2 != 0) {
				numberOfRoomsNeed = (int) Math.round(numberOfRoomsNeed);
			}
			System.out.println(numberOfRoomsNeed);
			int total = 0;
			for (Room room : roomCanBeRent) {
				result.add(roomConverter.toDto(room));
				total += room.getPrice();
				numberOfRoomsNeed -= 1;
				if (numberOfRoomsNeed <= 0) {
					break;
				}
			}
			if (numberOfRoomsNeed > 0) {
				result = new ArrayList<RoomDTO>();
			}
		}
		return result;
	}

	public ArrayList<RoomDTO> findRoom(int bill_ID) {
		ArrayList<RoomDTO> result = new ArrayList<RoomDTO>();
		ArrayList<Room> cancelRoom = new ArrayList<Room>();
		// Tim tat ca hoa don trong thoi gian do
		Bill bill = billRepository.find(bill_ID, "OnGoing");
		// tim phong can huy
		List<BillDetails> billDetails = bill.getBillDetails();

		for (BillDetails billDetail : billDetails) {
			Room room = billDetail.getRoom();
			cancelRoom = roomRepository.findRoom(room.getRoomNumber());

		}

		if (cancelRoom.size() != 0) {
			int total = 0;
			for (Room room : cancelRoom) {
				result.add(roomConverter.toDto(room));
				total += room.getPrice();
			}
		}

		return result;
	}

}

package com.nhapmoncongnghephanmem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.entity.Room;
import com.nhapmoncongnghephanmem.repository.CategoryRoomRepository;

@Component
public class RoomConverter {
	@Autowired
	private CategoryRoomRepository categoryRoomRepository;

	public RoomDTO toDto(Room entity) {
		int roomNumber = entity.getRoomNumber();
		int numberOfPeople = entity.getNumberOfPeople();
		String categoryRoom = entity.getCategoryRoom().getName();
		double price = entity.getPrice();
		RoomDTO result = new RoomDTO(roomNumber, categoryRoom, numberOfPeople, price);
		return result;
	}

	public Room toEntity(RoomDTO dto) {
		int roomNumber = dto.getRoomNumber();
		int numberOfPeople = dto.getNumberOfPeople();
		CategoryRoom categoryRoom = categoryRoomRepository.findOneByName(dto.getCategoryRoom());
		double price = dto.getPrice();
		Room result = new Room(roomNumber, categoryRoom, numberOfPeople, price);
		return result;
	}

}

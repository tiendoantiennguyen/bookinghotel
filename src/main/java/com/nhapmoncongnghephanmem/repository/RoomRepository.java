package com.nhapmoncongnghephanmem.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	ArrayList<Room> findRoomByCategoryRoomCategoryRoomID(int id);
	ArrayList<Room> findRoomByRoomNumberNotInAndCategoryRoomCategoryRoomIDAndNumberOfPeople(ArrayList<Integer> roomNumbers, int categoryRoomID, int numberOfPeople);

	ArrayList<Room> findRoomByCategoryRoomCategoryRoomIDAndNumberOfPeople(int categoryRoomID,
			int numberOfPeopleInARoom);
	@Query ( value = "Select * from room Where (roomNumber = ?1)", nativeQuery = true)
	ArrayList<Room> findRoom(int roomNumber);
}

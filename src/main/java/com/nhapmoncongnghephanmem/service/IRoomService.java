package com.nhapmoncongnghephanmem.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nhapmoncongnghephanmem.dto.RoomDTO;

public interface IRoomService {
	
	List<RoomDTO> findAll(Pageable pageable);
	int getTotalItem();
	RoomDTO findById(long id);
	RoomDTO save(RoomDTO dto);
	void delete(long[] ids);


}

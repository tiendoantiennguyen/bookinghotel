package com.nhapmoncongnghephanmem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhapmoncongnghephanmem.converter.CategoryRoomConverter;
import com.nhapmoncongnghephanmem.dto.CategoryRoomDTO;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.entity.Image;
import com.nhapmoncongnghephanmem.repository.CategoryRoomRepository;
import com.nhapmoncongnghephanmem.service.ICategoryRoomService;

@Service
public class CategoryRoomService {

	@Autowired
	private CategoryRoomRepository categoryRoomRepository;
	@Autowired
	private CategoryRoomConverter categoryRoomConverter;


	public ArrayList<CategoryRoomDTO> findAll() {
		ArrayList<CategoryRoomDTO> result = new ArrayList<CategoryRoomDTO>();
		List<CategoryRoom> categoryRooms = categoryRoomRepository.findAll();
		for (CategoryRoom categoryRoom : categoryRooms) {
			result.add(categoryRoomConverter.toDto(categoryRoom));
		}
		return result;

	};

	public ArrayList<String> findImageByCategoryRoomID(int categoryRoomID) {
		CategoryRoom categoryRoom = categoryRoomRepository.findOneByCategoryRoomID(categoryRoomID);
		CategoryRoomDTO categoryRoomDTO = categoryRoomConverter.toDto(categoryRoom);
		return categoryRoomDTO.getImagesURL();
	}
	
	public CategoryRoom findByCategoryRoomID(int categoryRoomID) {
		return this.categoryRoomRepository.findOneByCategoryRoomID(categoryRoomID);
		
	}

}

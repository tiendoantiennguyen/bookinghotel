package com.nhapmoncongnghephanmem.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nhapmoncongnghephanmem.dto.CategoryRoomDTO;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;
import com.nhapmoncongnghephanmem.entity.Image;

@Component
public class CategoryRoomConverter {

	public CategoryRoomDTO toDto(CategoryRoom entity) {
		List<Image> images = entity.getImageList();
		ArrayList<String> url = new ArrayList<String>();
		for (Image image : images) {
			url.add(image.getURL());
		}
		CategoryRoomDTO result = new CategoryRoomDTO(entity.getCategoryRoomID(), entity.getName(), url);
		return result;
	}

	public CategoryRoom toEntity(CategoryRoomDTO dto) {
		CategoryRoom result = new CategoryRoom(dto.getCategoryRoomID(), dto.getName());
		return result;
	}
}

package com.nhapmoncongnghephanmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhapmoncongnghephanmem.entity.CategoryRoom;

public interface CategoryRoomRepository extends JpaRepository<CategoryRoom, Long>{
	CategoryRoom  findOneByCategoryRoomID(int categoryRoomID);
	CategoryRoom findOneByName(String name);
	
}



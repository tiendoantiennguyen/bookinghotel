package com.nhapmoncongnghephanmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nhapmoncongnghephanmem.entity.CodeDetails;

public interface CodeDetailsRepository extends JpaRepository<CodeDetails, Long> {
	@Modifying
	@Query(value = "insert into code_details(roomNumber, randomCode, price) VALUES (?1,?2,?3)", nativeQuery = true)
	@Transactional
	void insertCodeDetails(int roomNumber, String randomCode, double price);
}

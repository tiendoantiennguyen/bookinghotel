package com.nhapmoncongnghephanmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nhapmoncongnghephanmem.entity.Code;

public interface ICodeRepository extends JpaRepository<Code, String> {
	@Modifying
	@Query(value = "insert into code VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
	
	@Transactional
	void insertCode(String randomCode, String fullName, String phoneNumber, String email, String cmnd,
			String checkInDate, String checkOutDate, String specialRequest, String paymentMethod);
	
	@Query(value = "select * from code where (randomCode = ?1)", nativeQuery = true)
	Code findOneByRandomCode(String randomCode);
}

package com.nhapmoncongnghephanmem.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhapmoncongnghephanmem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query(value = "Select * from bill Where ((checkInDate > ?1 AND checkInDate > ?2) OR (checkOutDate < ?1 AND checkOutDate < ?2)) AND status = ?3", nativeQuery = true)
	ArrayList<Bill> find(String checkInDate, String checkOutDate, String status);

	@Query(value = "Select * from bill Where (bill_ID = ?1) AND status = ?2", nativeQuery = true)
	Bill find(int bill_ID, String status);

	@Query(value = "Select * from bill Where (bill_ID = ?1)", nativeQuery = true)
	Bill find(int bill_ID);
}

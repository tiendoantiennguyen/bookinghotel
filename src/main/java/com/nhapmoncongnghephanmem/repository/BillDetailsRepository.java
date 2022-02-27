package com.nhapmoncongnghephanmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nhapmoncongnghephanmem.entity.BillDetails;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {
	@Query(value = "Select * from bill_details Where (bill_ID = ?1)", nativeQuery = true)
	BillDetails find(int bill_ID);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bill_details Where (bill_ID = ?1)", nativeQuery = true)
	void delete(int bill_ID);

}

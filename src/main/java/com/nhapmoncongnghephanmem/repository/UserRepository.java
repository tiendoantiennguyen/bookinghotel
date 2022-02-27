package com.nhapmoncongnghephanmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhapmoncongnghephanmem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUserNameAndStatus(String name, int status);

	User findOneByUserName(String userName);

	@Query(value = "Select * from user Where (userID = ?1) ", nativeQuery = true)
	User findUser(int userID);
}

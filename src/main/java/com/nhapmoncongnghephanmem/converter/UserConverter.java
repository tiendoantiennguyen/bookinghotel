package com.nhapmoncongnghephanmem.converter;

import org.springframework.stereotype.Component;

import com.nhapmoncongnghephanmem.dto.UserDTO;
import com.nhapmoncongnghephanmem.entity.User;

@Component
public class UserConverter {

	public User toEntity(UserDTO userDAO) {
		User results = new User();
		results.setUserName(userDAO.getUserName());
		results.setFullName(userDAO.getFullName());
		results.setEmail(userDAO.getEmail());
		results.setPhoneNumber(userDAO.getPhoneNumber());
		results.setPassword(userDAO.getPassword());
		return results;
	}

}

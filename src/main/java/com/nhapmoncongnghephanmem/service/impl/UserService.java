package com.nhapmoncongnghephanmem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhapmoncongnghephanmem.converter.UserConverter;
import com.nhapmoncongnghephanmem.dto.UserDTO;
import com.nhapmoncongnghephanmem.entity.User;
import com.nhapmoncongnghephanmem.repository.UserRepository;
import com.nhapmoncongnghephanmem.service.IUserService;


@Service
public class UserService implements IUserService{
	
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO insert(UserDTO userDTO) {

		return userDTO ;
	}

	@Override
	public void save(UserDTO userDTO) {
		User userEntity = new User();			
		userEntity =userConverter.toEntity( userDTO);
		userRepository.save(userEntity);
		
	}

	@Override
	public String checkTendangnhap(String userName) {
		User tk = userRepository.findOneByUserName(userName);
		return (tk==null) ? "no":"yes";
	}
	
	

}

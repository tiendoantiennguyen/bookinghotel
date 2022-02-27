package com.nhapmoncongnghephanmem.service;

import com.nhapmoncongnghephanmem.dto.UserDTO;

public interface IUserService {
	public UserDTO insert(UserDTO userDTO);

	public void save(UserDTO userDTO);

	public String checkTendangnhap(String userName);
}

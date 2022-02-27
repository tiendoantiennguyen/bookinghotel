package com.nhapmoncongnghephanmem.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nhapmoncongnghephanmem.dto.MyUser;
import com.nhapmoncongnghephanmem.dto.UserDTO;
import com.nhapmoncongnghephanmem.service.IUserService;


@Controller(value = "userApiOfWeb")
public class UserAPI {
	

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public void createNew(@RequestBody UserDTO userDTO) {
		 userService.save(userDTO);
	}

	@PutMapping("/api/user")
	public MyUser updateNew(@RequestBody MyUser myUser) {

		return myUser;
	}

	@DeleteMapping("/api/user")
	public void deleteNew(@RequestBody long[] ids) {
		System.out.println("ok");

	}

}

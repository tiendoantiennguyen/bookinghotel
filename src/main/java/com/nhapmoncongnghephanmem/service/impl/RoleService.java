package com.nhapmoncongnghephanmem.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhapmoncongnghephanmem.entity.Role;
import com.nhapmoncongnghephanmem.repository.RoleRepository;
import com.nhapmoncongnghephanmem.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired RoleRepository rolerepository;
	
	@Override
	public Set<Role> roles(long id) {
		Set<Role> roles = new HashSet<Role>();
		roles.add(rolerepository.findOne(id));
		return roles;
	}

}

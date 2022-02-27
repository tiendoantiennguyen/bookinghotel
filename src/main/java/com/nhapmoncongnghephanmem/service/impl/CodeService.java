package com.nhapmoncongnghephanmem.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhapmoncongnghephanmem.dto.CodeDTO;
import com.nhapmoncongnghephanmem.dto.RoomDTO;
import com.nhapmoncongnghephanmem.entity.Code;
import com.nhapmoncongnghephanmem.entity.CodeDetails;
import com.nhapmoncongnghephanmem.repository.CodeDetailsRepository;
import com.nhapmoncongnghephanmem.repository.ICodeRepository;

@Service
public class CodeService {

	@Autowired
	private ICodeRepository codeRepository;
	@Autowired
	private CodeDetailsRepository codeDetailsRepository;

	public void saveCode(Code code) {
		codeRepository.save(code);
	}

	public void saveCodeDetails(CodeDetails codeDetails) {
		codeDetailsRepository.save(codeDetails);

	}
}

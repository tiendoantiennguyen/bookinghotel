package com.nhapmoncongnghephanmem.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nhapmoncongnghephanmem.dto.CodeDTO;
import com.nhapmoncongnghephanmem.entity.Code;
@Component
public class CodeConverter {

	public Code toEntity(CodeDTO codeDTO) throws ParseException {
		Code result = new Code();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		result.setCheckInDate(simpleDateFormat.parse(codeDTO.getCheckInDate()));
		result.setCheckOutDate(simpleDateFormat.parse(codeDTO.getCheckOutDate()));
		result.setCMND(codeDTO.getCMND());
		result.setFullName(codeDTO.getFullName());
		result.setEmail(codeDTO.getEmail());
		result.setPaymentMethod(codeDTO.getPaymentMethod());
		result.setPhoneNumber(codeDTO.getPhoneNumber());
		result.setRandomCode(codeDTO.getRandomCode());
		result.setSpecialRequest(codeDTO.getSpecialRequest());
		return result;

	}

}

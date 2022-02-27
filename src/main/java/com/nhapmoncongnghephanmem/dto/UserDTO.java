package com.nhapmoncongnghephanmem.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.nhapmoncongnghephanmem.entity.Role;

public class UserDTO {

	private int userID;
	private String userName;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String password;
	private String CMND;
	private int status;
	private List<Role> roles = new ArrayList<>();

	public UserDTO(String userName, String fullName, String phoneNumber, String email, String password, String CMND,
			int status) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.CMND = CMND;
		this.status = status;
	}

	public UserDTO() {

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

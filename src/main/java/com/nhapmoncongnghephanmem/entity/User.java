package com.nhapmoncongnghephanmem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;

	@Column(name = "userName", unique = true)
	private String userName;
	
	@Column(name = "fullName")
	private String fullName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "CMND")
	private String CMND;

	@Column(name = "status")
	private int status;
	
	public User() {
	}

	public User(String userName, String fullName, String phoneNumber, String email, String password, String CMND,
			int status, List<Role> roles) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.CMND = CMND;
		this.status = status;
		this.roles = roles;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
	private List<Role> roles = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Bill> Bill = new ArrayList<>();
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	

}

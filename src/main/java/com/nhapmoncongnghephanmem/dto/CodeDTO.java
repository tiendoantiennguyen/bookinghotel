package com.nhapmoncongnghephanmem.dto;

import java.sql.Date;
import java.util.ArrayList;

import com.nhapmoncongnghephanmem.entity.Room;

public class CodeDTO {
	private String randomCode;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String CMND;
	private String checkInDate;
	private String checkOutDate;
	private String specialRequest;
	private String paymentMethod;
	private CategoryRoomDTO categoryRoom;
	private ArrayList<RoomDTO> rooms;

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
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

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ArrayList<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomDTO> rooms) {
		this.rooms = rooms;
	}

	public double totalPrice() {
		double result = 0;
		for (RoomDTO roomDTO : rooms) {
			result += roomDTO.getPrice();
		}
		return result;
	}

	public CategoryRoomDTO getCategoryRoom() {
		return categoryRoom;
	}

	public void setCategoryRoom(CategoryRoomDTO categoryRoom) {
		this.categoryRoom = categoryRoom;
	}

	public int getNumberOfPeopleInARoom() {
		return rooms.get(0).getNumberOfPeople();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}

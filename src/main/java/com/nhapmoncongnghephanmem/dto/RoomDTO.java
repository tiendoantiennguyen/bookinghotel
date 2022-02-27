package com.nhapmoncongnghephanmem.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.nhapmoncongnghephanmem.entity.Bill;
import com.nhapmoncongnghephanmem.entity.CategoryRoom;

public class RoomDTO {
	private int roomNumber;
	private String categoryRoom;
	private int numberOfPeople;
	private Double price;

	public RoomDTO() {
	}

	public RoomDTO(int roomNumber, String categoryRoom, int numberOfPeople, Double price) {
		super();
		this.roomNumber = roomNumber;
		this.categoryRoom = categoryRoom;
		this.numberOfPeople = numberOfPeople;
		this.price = price;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCategoryRoom() {
		return categoryRoom;
	}

	public void setCategoryRoom(String categoryRoom) {
		this.categoryRoom = categoryRoom;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RoomDTO [roomNumber=" + roomNumber + ", categoryRoom=" + categoryRoom + ", numberOfPeople="
				+ numberOfPeople + ", price=" + price + "]";
	}

}

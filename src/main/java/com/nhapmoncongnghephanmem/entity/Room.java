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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	private int roomNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryRoomID")
	private CategoryRoom categoryRoom;

	@Column(name = "numberOfPeople")
	private int numberOfPeople;

	@Column(name = "price")
	private Double price;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private List<BillDetails> billDetails;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private List<CodeDetails> codeDetails;

	public Room() {
		super();
	}

	public Room(int roomNumber, CategoryRoom categoryRoom, int numberOfPeople, Double price) {
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

	public CategoryRoom getCategoryRoom() {
		return categoryRoom;
	}

	public void setCategoryRoom(CategoryRoom categoryRoom) {
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

	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}
	

}

package com.nhapmoncongnghephanmem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details")
public class BillDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billDetailsID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomID")
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_ID")
	private Bill bill;

	private double price;
	

	public BillDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getBillDetailsID() {
		return billDetailsID;
	}

	public void setBillDetailsID(int billDetailsID) {
		this.billDetailsID = billDetailsID;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

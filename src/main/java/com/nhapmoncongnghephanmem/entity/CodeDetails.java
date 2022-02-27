package com.nhapmoncongnghephanmem.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "code_details")
public class CodeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeDetailsID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomID")
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "randomCode")
	private Code code;

	private double price;

	public CodeDetails() {
		// TODO Auto-generated constructor stub
	}


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public Code getCode() {
		return code;
	}


	public void setCode(Code code) {
		this.code = code;
	}

}

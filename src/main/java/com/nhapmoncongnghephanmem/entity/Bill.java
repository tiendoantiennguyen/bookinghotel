package com.nhapmoncongnghephanmem.entity;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bill_ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	private User user;

	@Column(name = "checkInDate")
	private Date checkInDate;
	
	@Column(name = "checkOutDate")
	private Date checkOutDate;

	@Column(name = "specialRequest")
	private String specialRequest;

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "status")
	private String status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	private List<BillDetails> billDetails;

	public int getBill_ID() {
		return bill_ID;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBill_ID(int bill_ID) {
		this.bill_ID = bill_ID;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}

}

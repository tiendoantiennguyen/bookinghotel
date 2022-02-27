package com.nhapmoncongnghephanmem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_room")
public class CategoryRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryRoomID;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "categoryRoom")
	private List<Room> rooms = new ArrayList<>();

	@OneToMany(mappedBy = "categoryRoom")
	private List<Image> imageList = new ArrayList<>();

	public CategoryRoom() {
		super();
	}

	public CategoryRoom(int categoryRoomID, String name) {
		super();
		this.categoryRoomID = categoryRoomID;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public int getCategoryRoomID() {
		return categoryRoomID;
	}

	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

}

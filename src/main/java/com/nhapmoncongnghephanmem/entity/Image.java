package com.nhapmoncongnghephanmem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryRoomID")
	private CategoryRoom categoryRoom;

	@Column(name = "URL")
	private String URL;

	public int getImageID() {
		return imageID;
	}

	public CategoryRoom getCategoryRoom() {
		return categoryRoom;
	}

	public void setCategoryRoom(CategoryRoom categoryRoom) {
		this.categoryRoom = categoryRoom;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

}

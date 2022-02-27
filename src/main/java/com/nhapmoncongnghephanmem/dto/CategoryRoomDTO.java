package com.nhapmoncongnghephanmem.dto;

import java.util.ArrayList;

public class CategoryRoomDTO extends AbstractDTO<CategoryRoomDTO> {

	private int categoryRoomID;
	private String name;
	private ArrayList<String> imagesURL;

	public CategoryRoomDTO() {
		super();
	}

	public CategoryRoomDTO(int categoryRoomID, String name) {
		super();
		this.categoryRoomID = categoryRoomID;
		this.name = name;
	}

	public CategoryRoomDTO(int categoryRoomID, String name, ArrayList<String> imagesURL) {
		super();
		this.categoryRoomID = categoryRoomID;
		this.name = name;
		this.imagesURL = imagesURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryRoomID() {
		return categoryRoomID;
	}

	public void setCategoryRoomID(int categoryRoomID) {
		this.categoryRoomID = categoryRoomID;
	}

	public ArrayList<String> getImagesURL() {
		return imagesURL;
	}

	public void setImagesURL(ArrayList<String> imagesURL) {
		this.imagesURL = imagesURL;
	}

}

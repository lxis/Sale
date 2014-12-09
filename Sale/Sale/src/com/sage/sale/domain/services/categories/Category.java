package com.sage.sale.domain.services.categories;

public class Category {

	public Category()
	{
		
	}
	
	public Category(String name)
	{
		this.name = name;
	}
	
	private String name;
	private int id;
	private int imageId; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}

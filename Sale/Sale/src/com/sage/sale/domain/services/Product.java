package com.sage.sale.domain.services;

public class Product {
	
	public Product()
	{
		
	}
	
	public Product(String url,String name,int imageResourceId)
	{
		this.url = url;
		this.name = name;
		this.imageResourceId = imageResourceId;
	}
	
	private String url;
	private String name;
	private int percent;
	private int imageResourceId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public void addPercent(int percent)
	{
		this.percent+=percent;
	}

	public int getImageResourceId() {
		return imageResourceId;
	}

	public void setImageResourceId(int imageResourceId) {
		this.imageResourceId = imageResourceId;
	}
}

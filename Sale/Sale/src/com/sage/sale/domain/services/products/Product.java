package com.sage.sale.domain.services.products;

public class Product {
	
	public Product()
	{
		
	}
	
	public Product(String name,String url,int imageResourceId,int id)
	{
		this.url = url;
		this.name = name;
		this.imageResourceId = imageResourceId;
		this.id=id;
	}
	
	public Product(String name,String url,String imageUrl,int id)
	{
		this.url = url;
		this.name = name;
		this.setImageUrl(imageUrl);
		this.id = id;
	}
	
	private String url;
	private String name;
	private int percent;
	private int imageResourceId;
	private String imageUrl;
	private int id;

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

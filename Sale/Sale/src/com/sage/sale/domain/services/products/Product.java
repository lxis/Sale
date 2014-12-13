package com.sage.sale.domain.services.products;

import java.util.ArrayList;

public class Product {
	
	public Product()
	{
		
	}	

	
	public Product(String name,String url,String imageUrl,String evaluation,int id)
	{
		this.url = url;
		this.name = name;
		this.setImageUrl(imageUrl);
		this.id = id;
		this.setEvaluation(evaluation);

	}
	
	private String evaluation;
	private String url;
	private String name;
	private int value;
	private int price;
	private int imageResourceId;
	private String imageUrl;
	private int id;
	private ArrayList<ProductValue> matches = new ArrayList<ProductValue>();
	
	
	
	public Product addMatch(String matchText,int score)
	{
		matches.add(new ProductValue(matchText, score));
		return this;
	}
	
	public Product addMatch(String matchText)
	{
		matches.add(new ProductValue(matchText));
		return this;
	}
	
	public ArrayList<ProductValue> getMatches()
	{
		return matches;
	}	

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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	public Product addValue(int value)
	{
		this.value+=value;
		return this;
	}
	
	public Product addValue(double value,String name)
	{
		this.value+=value;
		matches.add(new ProductValue(name, (int)value));
		return this;
	}
	
	public Product addValue(double value,String name,String text)
	{
		this.value+=value;
		matches.add(new ProductValue(name, (int)value,text));
		return this;
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

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
		addValue(- price);
	}
}

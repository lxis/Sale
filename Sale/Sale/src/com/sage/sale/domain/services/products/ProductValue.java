package com.sage.sale.domain.services.products;

public class ProductValue {
	private String name;
	private int value;
	private String text;
	public ProductValue(String name,int score)
	{
		this.setName(name);
		this.setValue(score);
	}
	
	public ProductValue(String name,int score,String text)
	{
		this.setName(name);
		this.setValue(score);
		this.setText(text);
	}
	
	public ProductValue(String text)
	{
		this.setName(text);
	}
	public String getName() {
		return name;
	}
	public void setName(String text) {
		this.name = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int score) {
		this.value = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

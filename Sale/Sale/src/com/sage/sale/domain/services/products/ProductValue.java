package com.sage.sale.domain.services.products;

public class ProductValue {
	private String text;
	private int value;
	public ProductValue(String text,int score)
	{
		this.setText(text);
		this.setValue(score);
	}
	
	public ProductValue(String text)
	{
		this.setText(text);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int score) {
		this.value = score;
	}
}

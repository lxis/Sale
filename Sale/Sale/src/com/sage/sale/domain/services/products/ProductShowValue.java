package com.sage.sale.domain.services.products;

public class ProductShowValue {
	private String name;
	private double value;
	private String text;

	public ProductShowValue(String name, double score) {
		this.setName(name);
		this.setValue(score);
	}
	
	public ProductShowValue(String name, double score,String text) {
		this.setName(name);
		this.setValue(score);
		this.setText(text);
	}

	public ProductShowValue(String text) {
		this.setName(text);
	}

	public String getName() {
		return name;
	}

	public void setName(String text) {
		this.name = text;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double score) {
		this.value = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

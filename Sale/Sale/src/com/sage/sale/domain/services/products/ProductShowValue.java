package com.sage.sale.domain.services.products;

public class ProductShowValue {
	private String text;
	private double value;

	public ProductShowValue(String text, double score) {
		this.setText(text);
		this.setValue(score);
	}

	public ProductShowValue(String text) {
		this.setText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double score) {
		this.value = score;
	}
}

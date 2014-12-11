package com.sage.sale.domain.services.products;

public class Match {
	private String text;
	private int score;
	public Match(String text,int score)
	{
		this.setText(text);
		this.setScore(score);
	}
	
	public Match(String text)
	{
		this.setText(text);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

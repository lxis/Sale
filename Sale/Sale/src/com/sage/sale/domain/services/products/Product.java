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
	private int percent;
	private int imageResourceId;
	private String imageUrl;
	private int id;
	private ArrayList<Match> matches = new ArrayList<Match>();
	
	public Product addMatch(String matchText,int score)
	{
		matches.add(new Match(matchText, score));
		return this;
	}
	
	public Product addMatch(String matchText)
	{
		matches.add(new Match(matchText));
		return this;
	}
	
	public ArrayList<Match> getMatches()
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

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public Product addPercent(int percent)
	{
		this.percent+=percent;
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
}

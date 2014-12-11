package com.sage.sale.domain.services.categories;

import com.google.gson.Gson;
import com.sage.sale.domain.services.products.Product;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Category {

	public Category()
	{
		
	}
	
	public Category(String name)
	{
		this.name = name;
	}
	
	private String name;
	protected int id;
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

	public Product getTestedResult(Context context) {		
		SharedPreferences sharePreference = context.getSharedPreferences("Category", context.MODE_PRIVATE)  ;
		String json = sharePreference.getString(String.valueOf(id),new Gson().toJson(new CategoryStorage()));		
		CategoryStorage categoryStorage =	new Gson().fromJson(json, CategoryStorage.class);
		return categoryStorage.ResultProduct;		
	}

	public void saveTestedResult(Context context, Product testedProduct) {
		SharedPreferences sharePreference = context.getSharedPreferences("Category", context.MODE_PRIVATE)  ;		
		String originalJson = sharePreference.getString(String.valueOf(id),new Gson().toJson(new CategoryStorage()));	
		CategoryStorage categoryStorage =	new Gson().fromJson(originalJson, CategoryStorage.class);
		categoryStorage.ResultProduct = testedProduct;
		String resultJson = new Gson().toJson(categoryStorage);						
		Editor editor = sharePreference.edit();
		editor.putString(String.valueOf(id), resultJson);
		editor.commit();
	}		
}

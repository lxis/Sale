package com.sage.sale.domain.services.categories;

import java.util.ArrayList;

import com.sage.sale.domain.services.categories.beauty.*;

public class CategoryFactory {
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(new HuaZhuangShui());
		categories.add(new MianMo());
		categories.add(new GeLi());
		//categories.add(new MianShuang());
		//categories.add(new YanShuang());
		categories.add(new XiMianNai());
		return categories;
	}
	
//	public ArrayList<Category> getAllCategory()
//	{
//		ArrayList<Category> categories = new ArrayList<Category>();
//		categories.add(new Phone());
//		categories.add(new LapTop());
//		categories.add(new Tablet());
//		categories.add(new TV());
//		categories.add(new PC());
//		return categories;
//	}
}

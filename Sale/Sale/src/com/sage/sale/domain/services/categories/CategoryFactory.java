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
		categories.add(new XiMianNai());
		return categories;
	}
	
}

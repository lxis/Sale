package com.sage.sale.domain.services.categories;

import java.util.ArrayList;

import com.sage.sale.domain.services.categories.electric.LapTop;
import com.sage.sale.domain.services.categories.electric.PC;
import com.sage.sale.domain.services.categories.electric.Phone;
import com.sage.sale.domain.services.categories.electric.TV;
import com.sage.sale.domain.services.categories.electric.Tablet;

public class CategoryFactory {
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(new Phone());
		categories.add(new LapTop());
		categories.add(new Tablet());
		categories.add(new TV());
		categories.add(new PC());
		return categories;
	}
}

package com.sage.sale.domain.services.categories;

import java.util.ArrayList;

<<<<<<< HEAD
import com.sage.sale.domain.services.categories.beauty.*;
=======
import com.sage.sale.domain.services.categories.electric.LapTop;
import com.sage.sale.domain.services.categories.electric.PC;
import com.sage.sale.domain.services.categories.electric.Phone;
import com.sage.sale.domain.services.categories.electric.TV;
import com.sage.sale.domain.services.categories.electric.Tablet;
>>>>>>> origin/master

public class CategoryFactory {
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> categories = new ArrayList<Category>();
<<<<<<< HEAD
		categories.add(new GeLi());
		categories.add(new HuaZhuangShui());
		categories.add(new MianMo());
		categories.add(new MianShuang());
		categories.add(new YanShuang());
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
=======
		categories.add(new Phone());
		categories.add(new LapTop());
		categories.add(new Tablet());
		categories.add(new TV());
		categories.add(new PC());
		return categories;
	}
>>>>>>> origin/master
}

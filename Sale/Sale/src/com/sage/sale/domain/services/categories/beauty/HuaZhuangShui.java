package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class HuaZhuangShui  extends Category {
	
	public HuaZhuangShui()
	{
		id = 2;
	}
	
	@Override
	public String getName() {
		return "»¯×±Ë®";
	}

	@Override
	public int getId() {
		return id;
	}
	
	
	@Override
	public int getImageId() {
		return R.drawable.categories_hua_zhuang_shui;
	}
}

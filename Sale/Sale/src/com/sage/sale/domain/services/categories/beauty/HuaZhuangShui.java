package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class HuaZhuangShui  extends Category {
	@Override
	public String getName() {
		return "»¯×±Ë®";
	}

	@Override
	public int getId() {
		return 2;
	}
	
	
	@Override
	public int getImageId() {
		return R.drawable.categories_hua_zhuang_shui;
	}
}

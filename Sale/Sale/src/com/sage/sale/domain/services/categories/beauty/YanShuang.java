package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class YanShuang  extends Category {
	@Override
	public String getName() {
		return "ÑÛËª";
	}

	@Override
	public int getId() {
		return 5;
	}	
	
	@Override
	public int getImageId() {
		return R.drawable.categories_yan_shuang;
	}
}

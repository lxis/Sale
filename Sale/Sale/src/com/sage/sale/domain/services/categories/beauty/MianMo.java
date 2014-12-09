package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class MianMo  extends Category {
	@Override
	public String getName() {
		return "ÃæÄ¤";
	}

	@Override
	public int getId() {
		return 3;
	}
	
	@Override
	public int getImageId() {
		return R.drawable.categories_mian_mo;
	}
}

package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class MianMo  extends Category {
	
	public MianMo()
	{
		id = 3;
	}
	
	@Override
	public String getName() {
		return "ÃæÄ¤";
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public int getImageId() {
		return R.drawable.categories_mian_mo;
	}
}

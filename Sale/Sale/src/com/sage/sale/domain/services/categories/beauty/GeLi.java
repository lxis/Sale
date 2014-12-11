package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class GeLi  extends Category {
	
	public GeLi()
	{
		id = 1;
	}
	
	@Override
	public String getName() {
		return "∏Ù¿Î";
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public int getImageId() {
		return R.drawable.categories_ge_li;
	}
}

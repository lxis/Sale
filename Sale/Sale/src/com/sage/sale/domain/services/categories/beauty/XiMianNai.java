package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class XiMianNai   extends Category {
	@Override
	public String getName() {
		return "Ï´ÃæÄÌ";
	}

	@Override
	public int getId() {
		return 6;
	}	
	
	@Override
	public int getImageId() {
		return R.drawable.categories_xi_mian_nai;
	}
}

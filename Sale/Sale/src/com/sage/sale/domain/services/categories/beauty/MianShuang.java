package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class MianShuang  extends Category {
	@Override
	public String getName() {
		return "��˪";
	}

	@Override
	public int getId() {
		return 4;
	}
	
	@Override
	public int getImageId() {
		return R.drawable.categories_mian_shuang;
	}
}

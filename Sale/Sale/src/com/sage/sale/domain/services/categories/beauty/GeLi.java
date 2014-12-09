package com.sage.sale.domain.services.categories.beauty;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;

public class GeLi  extends Category {
	@Override
	public String getName() {
		return "∏Ù¿Î";
	}

	@Override
	public int getId() {
		return 1;
	}
	
	@Override
	public int getImageId() {
		return R.drawable.categories_ge_li;
	}
}

package com.sage.sale.domain.services.categories.electric;

import com.sage.sale.domain.services.categories.Category;


public class PC  extends Category  {
	@Override
	public String getName() {
		return "PC";
	}
	
	@Override
	public int getId() {
		return 3;
	}
}

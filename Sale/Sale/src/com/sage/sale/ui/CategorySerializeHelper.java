package com.sage.sale.ui;

import com.sage.sale.domain.services.categories.*;
import com.sage.sale.domain.services.categories.beauty.*;

//Java中，一个派生类以其父类类型进行序列化再反序列化之后，就丢失了派生类类型信息，只好用这个
public class CategorySerializeHelper {

	int id;

	public CategorySerializeHelper(Category category) {
		id = category.getId();
	}

	public Category getCategory() {
		switch (id) {
		case 1:
			return new GeLi();
		case 2:
			return new HuaZhuangShui();
		case 3:
			return new MianMo();
		case 4:
			return new MianShuang();
		case 5:
			return new YanShuang();
		case 6:
			return new XiMianNai();
		default:
			break;
		}
		throw new RuntimeException();
	}
}

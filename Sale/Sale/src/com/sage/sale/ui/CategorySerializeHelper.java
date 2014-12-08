package com.sage.sale.ui;

import com.sage.sale.domain.services.categories.*;

//Java中，一个派生类以其父类类型进行序列化再反序列化之后，就丢失了派生类类型信息，只好用这个
public class CategorySerializeHelper {

	int id;

	public CategorySerializeHelper(Category category) {
		id = category.getId();
	}

	public Category getCategory() {
		switch (id) {
		case 1:
			return new Fridge();
		case 2:
			return new LapTop();
		case 3:
			return new PC();
		case 4:
			return new Phone();
		case 5:
			return new Tablet();
		case 6:
			return new TV();
		default:
			break;
		}
		throw new RuntimeException();
	}
}

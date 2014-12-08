package com.sage.sale.ui;

import com.sage.sale.domain.services.categories.*;

//Java�У�һ�����������丸�����ͽ������л��ٷ����л�֮�󣬾Ͷ�ʧ��������������Ϣ��ֻ�������
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

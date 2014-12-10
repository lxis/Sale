package com.sage.sale.ui;

import com.sage.sale.domain.services.categories.*;
import com.sage.sale.domain.services.categories.beauty.*;

//Java�У�һ�����������丸�����ͽ������л��ٷ����л�֮�󣬾Ͷ�ʧ��������������Ϣ��ֻ�������
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

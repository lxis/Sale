package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.XiMianNaiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire extends BaseQuestionnaire<XiMianNaiProductRepository> {

	public XiMianNaiQuestionnaire() {
		super(XiMianNaiProductRepository.class);
	}

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("���׹����Ƿ��ر���Ҫ��").addAnswer("�ǳ���Ҫ").addAnswer("һ����Ҫ"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣����150ML���㣩��").addAnswer("200����").addAnswer("200-400").addAnswer("400-800").addAnswer("800����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ����׹�����").addAnswer("������").addAnswer("������"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(17).addPercent(50);
		}
	}
}

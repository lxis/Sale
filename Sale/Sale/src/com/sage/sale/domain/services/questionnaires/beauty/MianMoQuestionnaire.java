package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.MianMoProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire extends BaseQuestionnaire<MianMoProductRepository> {

	public MianMoQuestionnaire() {
		super(MianMoProductRepository.class);
	}
	
//			"����ŷ���� ����͸�׳�ҹ���ɶ�Ĥ",11
//			"��ľ֮Դ ˮ����ҹ���ܼ�������Ĥ",12
//			"ˮ֥�� �沿����ҹ���ܼ���ˮ��Ĥ(����Ĥ)",13
//			"����ޢ õ����ˮ����Ĥ",14
//			"����ʫ ����ʪ��Ĥ",15

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
			productRepository.getProduct(12).addPercent(50);
		}
	}
}

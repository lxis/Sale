package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.GeLiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire extends BaseQuestionnaire<GeLiProductRepository> {

	public GeLiQuestionnaire() {
		super(GeLiProductRepository.class);
	}		

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("�������׻��ǲ�ˮ��").addAnswer("����").addAnswer("��ˮ"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣�").addAnswer("100����").addAnswer("100-200").addAnswer("200-300").addAnswer("300����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ���Ҫ���ͣ�").addAnswer("����Ҫ").addAnswer("��û�ж���"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("20-25").addAnswer("25-30").addAnswer("30-40").addAnswer("40����"));
	}

	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(4).addPercent(50);
		}		
	}
}

package com.sage.sale.domain.services.questionnaires.beauty;


import com.sage.sale.domain.services.products.beauty.XiMianNaiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire  extends BaseQuestionnaire<XiMianNaiProductRepository> {


	public XiMianNaiQuestionnaire() {
		super(XiMianNaiProductRepository.class);
	}	
	
	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(17).addPercent(50);
		}		
	}

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("�������׻��ǲ�ˮ��").addAnswer("����").addAnswer("��ˮ"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣�").addAnswer("100����").addAnswer("100-200").addAnswer("200-300").addAnswer("300����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ���Ҫ���ͣ�").addAnswer("����Ҫ").addAnswer("��û�ж���"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("20-25").addAnswer("25-30").addAnswer("30-40").addAnswer("40����"));
	}
}

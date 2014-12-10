package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.XiMianNaiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire extends BaseQuestionnaire<XiMianNaiProductRepository> {

	public XiMianNaiQuestionnaire() {
		super(XiMianNaiProductRepository.class);
	}
	
	
//			"������ϴ��ר�� �ᳺ��ĭ������",17 56
//			"¶���� ��㾻��ϴ���飩",18 36
//			"˿��ܽ ϴ����200ml",19 81
//			"ٻ�� Һ��������º��ͣ�",20 150
//			"¶���� �������ϴ����",21		 36

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("�Ƿ�����Ƥ����").addAnswer("��").addAnswer("����"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣����150ML���㣩��").addAnswer("50����").addAnswer("50-100").addAnswer("100-200").addAnswer("200����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ����׹�����").addAnswer("������").addAnswer("������"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	@Override
	protected void CalculateScore() {
		//�����ֵ
		getProduct(17).addPercent(100);
		getProduct(18).addPercent(80);
		getProduct(19).addPercent(60);
		getProduct(20).addPercent(40);
		getProduct(21).addPercent(20);
		
		
		if(getAnswer(0)==0)
		{
			getProduct(17).addPercent(100);
			getProduct(18).addPercent(100);
		}
		
		switch (getAnswer(1)) {
		case 0:
		{
			getProduct(17).addPercent(100);
			getProduct(18).addPercent(100);
			getProduct(19).addPercent(-100);
			getProduct(20).addPercent(-300);
			getProduct(21).addPercent(100);
			break;
		}
		case 1:
		{
			getProduct(17).addPercent(0);
			getProduct(18).addPercent(0);
			getProduct(19).addPercent(100);
			getProduct(20).addPercent(-200);
			getProduct(21).addPercent(0);
			break;
		}
		case 2:
		{
			getProduct(17).addPercent(0);
			getProduct(18).addPercent(0);
			getProduct(19).addPercent(0);
			getProduct(20).addPercent(100);
			getProduct(21).addPercent(0);
			break;
		}
		default:
			break;
		} 
		
		if(getAnswer(2)==0)
		{
			getProduct(18).addPercent(-100);
		}
		
		if(getAnswer(3)==0)
		{
			getProduct(19).addPercent(100);
			getProduct(20).addPercent(100);
		}						
	}
}

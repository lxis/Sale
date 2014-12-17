package com.sage.sale.domain.services.questionnaires.beauty;

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
		getProduct(17).addValue(100);
		getProduct(18).addValue(80);
		getProduct(19).addValue(60);
		getProduct(20).addValue(40);
		getProduct(21).addValue(20);
		
		
		if(getAnswer(0)==0)
		{
			getProduct(17).addValue(100,"�ʺ�����Ƥ��");
			getProduct(18).addValue(100,"�ʺ�����Ƥ��");
		}
		
		switch (getAnswer(1)) {
		case 0:
		{
			getProduct(17).addValue(100);
			getProduct(18).addValue(100);
			getProduct(19).addValue(-100);
			getProduct(20).addValue(-300);
			getProduct(21).addValue(100);
			break;
		}
		case 1:
		{
			getProduct(17).addValue(0);
			getProduct(18).addValue(0);
			getProduct(19).addValue(100);
			getProduct(20).addValue(-200);
			getProduct(21).addValue(0);
			break;
		}
		case 2:
		{
			getProduct(17).addValue(0);
			getProduct(18).addValue(0);
			getProduct(19).addValue(0);
			getProduct(20).addValue(100);
			getProduct(21).addValue(0);
			break;
		}
		default:
			break;
		} 
		
		if(getAnswer(2)==0)
		{
			getProduct(18).addValue(-100);
		}
		
		if(getAnswer(3)==0)
		{
			getProduct(19).addValue(100,"�º�");
			getProduct(20).addValue(100,"�º�");
		}						
	}
}

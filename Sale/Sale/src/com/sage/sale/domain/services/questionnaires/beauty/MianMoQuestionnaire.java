package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.MianMoProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire extends BaseQuestionnaire<MianMoProductRepository> {

	public MianMoQuestionnaire() {
		super(MianMoProductRepository.class);
	}

	// "����ŷ���� ����͸�׳�ҹ���ɶ�Ĥ",11 109
	// "��ľ֮Դ ˮ����ҹ���ܼ�������Ĥ",12 320
	// "ˮ֥�� �沿����ҹ���ܼ���ˮ��Ĥ(����Ĥ)",13 1000
	// "����ޢ õ����ˮ����Ĥ",14 380
	// "����ʫ ����ʪ��Ĥ",15 480

	protected void GenerateQuestionnaire() {
		
		lists.add(new Question().setQuestion("Ԥ���ж��٣����100ML���㣩��").addAnswer("200����").addAnswer("200-400").addAnswer("400-800").addAnswer("800����"));
		lists.add(new Question().setQuestion("�ǲ����ر�����ˬ��").addAnswer("������ˬ").addAnswer("���͵�û��ϵ"));
		lists.add(new Question().setQuestion("�Ƿ����׹�����").addAnswer("������").addAnswer("������"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	@Override
	protected void CalculateScore() {
		
		//�����ֵ
		getProduct(11).addValue(100);
		getProduct(12).addValue(80);
		getProduct(13).addValue(60);
		getProduct(14).addValue(40);
		getProduct(15).addValue(20);
		
		switch (getAnswer(0)) {
		case 0: {
			getProduct(11).addValue(100);
			getProduct(12).addValue(-200);
			getProduct(13).addValue(-1000);
			getProduct(14).addValue(-200);
			getProduct(15).addValue(-500);
			break;
		}
		case 1: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(100);
			getProduct(13).addValue(-750);
			getProduct(14).addValue(100);
			getProduct(15).addValue(-100);
			break;
		}
		case 2: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(0);
			getProduct(13).addValue(-500);
			getProduct(14).addValue(0);
			getProduct(15).addValue(100);
			break;
		}
		case 3: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(0);
			getProduct(13).addValue(100);
			getProduct(14).addValue(0);
			getProduct(15).addValue(0);
			break;
		}
		default:
			break;
		}		
		
		if(getAnswer(1)==0)
		{
			getProduct(12).addValue(-100);
		}
		
		if(getAnswer(2)==0)
		{
			getProduct(11).addValue(-100);
		}
		
		switch (getAnswer(3)) {
		case 0:
		case 1:
		{
			getProduct(13).addValue(100,"�º�");
			getProduct(15).addValue(100,"�º�");
			
			break;
		}
		case 2:
		case 3:
		{
			getProduct(11).addValue(100,"��˥��");
			getProduct(12).addValue(100,"��˥��");
			getProduct(14).addValue(100,"��˥��");
			break;
		}
		default:
			break;
		}
		

	}
}

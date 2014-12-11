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
		getProduct(11).addPercent(100).addMatch("�����ھ�");
		getProduct(12).addPercent(80).addMatch("��������",9);
		getProduct(13).addPercent(60).addMatch("��������",9);
		getProduct(14).addPercent(40);
		getProduct(15).addPercent(20);
		
		switch (getAnswer(0)) {
		case 0: {
			getProduct(11).addPercent(100);
			getProduct(12).addPercent(-200);
			getProduct(13).addPercent(-1000);
			getProduct(14).addPercent(-200);
			getProduct(15).addPercent(-500);
			break;
		}
		case 1: {
			getProduct(11).addPercent(0);
			getProduct(12).addPercent(100);
			getProduct(13).addPercent(-750);
			getProduct(14).addPercent(100);
			getProduct(15).addPercent(-100);
			break;
		}
		case 2: {
			getProduct(11).addPercent(0);
			getProduct(12).addPercent(0);
			getProduct(13).addPercent(-500);
			getProduct(14).addPercent(0);
			getProduct(15).addPercent(100);
			break;
		}
		case 3: {
			getProduct(11).addPercent(0);
			getProduct(12).addPercent(0);
			getProduct(13).addPercent(100);
			getProduct(14).addPercent(0);
			getProduct(15).addPercent(0);
			break;
		}
		default:
			break;
		}		
		
		if(getAnswer(1)==0)
		{
			getProduct(12).addPercent(-100);
		}
		
		if(getAnswer(2)==0)
		{
			getProduct(11).addPercent(-100);
		}
		
		switch (getAnswer(3)) {
		case 0:
		case 1:
		{
			getProduct(13).addPercent(100).addMatch("�º�",10);
			getProduct(15).addPercent(100).addMatch("�º�",10);
			
			break;
		}
		case 2:
		case 3:
		{
			getProduct(11).addPercent(100).addMatch("��˥��");
			getProduct(12).addPercent(100).addMatch("��˥��");
			getProduct(14).addPercent(100).addMatch("��˥��");
			break;
		}
		default:
			break;
		}
		

	}
}

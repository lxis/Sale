package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.GeLiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire extends BaseQuestionnaire<GeLiProductRepository> {

	public GeLiQuestionnaire() {
		super(GeLiProductRepository.class);
	}

	// "���� ��ˬ������Я��ɹ��SPF30+��������ɹС��գ�",1 646
	// "¶���� ����׶໤��ɹ��ҺSPF30+ PA+++��",2 332
	// "���� ����������׸���˪SPF26/PA++",3 79
	// "¶���� ��͸��ɹ��SPF50",4 79
	// "�������� ���鼡͸��UV������Һ", 5 787

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("��ɹ�����Ƿ����50�ģ�").addAnswer("��").addAnswer("����"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣����50ML���㣩��").addAnswer("100����").addAnswer("100-200").addAnswer("200-400").addAnswer("400����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ��ˬ��").addAnswer("������ˬ").addAnswer("��Ч�þ��У�����������"));		
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	@Override
	protected void CalculateScore() {
		
		//�����ֵ
		getProduct(1).addPercent(100).addMatch("�����ھ�");
		getProduct(2).addPercent(80).addMatch("��������",9);
		getProduct(3).addPercent(60).addMatch("��������",9);
		getProduct(4).addPercent(40);
		getProduct(5).addPercent(20);
		
		if(getAnswer(0)==0)
		{
			getProduct(0).addMatch("�߱���ɹ");
			getProduct(1).addPercent(-500);
			getProduct(2).addPercent(-500);
			getProduct(3).addPercent(-500);			
			getProduct(5).addPercent(-500);
		}
		
		switch (getAnswer(1)) {
		case 0: {
			getProduct(1).addPercent(-1000);
			getProduct(2).addPercent(-500);
			getProduct(3).addPercent(100);
			getProduct(4).addPercent(100);
			getProduct(5).addPercent(-1000);
			break;
		}
		case 1: {
			getProduct(1).addPercent(-900);
			getProduct(2).addPercent(-300);
			getProduct(3).addPercent(0);
			getProduct(4).addPercent(0);
			getProduct(5).addPercent(-900);
			break;
		}
		case 2: {
			getProduct(1).addPercent(-400);
			getProduct(2).addPercent(100);
			getProduct(3).addPercent(0);
			getProduct(4).addPercent(0);
			getProduct(5).addPercent(-400);
			break;
		}
		case 3: {
			getProduct(1).addPercent(100);
			getProduct(2).addPercent(0);
			getProduct(3).addPercent(0);
			getProduct(4).addPercent(0);
			getProduct(5).addPercent(100);
			break;
		}
		default:
			break;
		}
		if (getAnswer(2) == 0) {
			getProduct(1).addPercent(100).addMatch("��ˬ������",9);
			getProduct(2).addPercent(100).addMatch("��ˬ������",9);
			getProduct(3).addPercent(100).addMatch("��ˬ������",9);			
		}
	}
}

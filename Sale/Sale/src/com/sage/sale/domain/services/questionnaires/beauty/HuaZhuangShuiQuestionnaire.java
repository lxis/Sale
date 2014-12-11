package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.HuaZhuangShuiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class HuaZhuangShuiQuestionnaire extends BaseQuestionnaire<HuaZhuangShuiProductRepository> {

	public HuaZhuangShuiQuestionnaire() {
		super(HuaZhuangShuiProductRepository.class);
	}	
//			"Pro-X White ���׷���ʽ���½��ʱ�ʪ�߻���ˮ",6  �� 340      
//			"SK-II ����ˮ��SK-II ��������¶��",7  �� 1,040
//			"���� �滤��Ȫ����",8  �� 125
//			"��˿ ѩ������ױˮ",9   285
//			"��ʫ���� ȫ���������ɾ���ˮ����ˬ�ͣ�",10   360

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("���׹����Ƿ��ر���Ҫ��").addAnswer("�ǳ���Ҫ").addAnswer("һ����Ҫ"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣����150ML���㣩��").addAnswer("200����").addAnswer("200-400").addAnswer("400-800").addAnswer("800����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ����׹�����").addAnswer("������").addAnswer("������"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	
	
	@Override
	protected void CalculateScore() {
		//�����ֵ
		getProduct(6).addPercent(100).addMatch("�����ھ�").addMatch("���̼�").addMatch("�޾ƾ�");
		getProduct(7).addPercent(80).addMatch("��������");
		getProduct(8).addPercent(60).addMatch("��������");
		getProduct(9).addPercent(40);
		getProduct(10).addPercent(20);
		
		if(getAnswer(0)==0)
		{
			getProduct(6).addPercent(100);
			getProduct(9).addPercent(100);
		}
		
		switch (getAnswer(1)) {
		case 0:
		{
			getProduct(6).addPercent(-300);
			getProduct(7).addPercent(-1000);
			getProduct(8).addPercent(200);
			getProduct(9).addPercent(-100);
			getProduct(10).addPercent(-300);
			break;
		}
		case 1:
		{
			getProduct(6).addPercent(100);
			getProduct(7).addPercent(-300);
			getProduct(8).addPercent(0);
			getProduct(9).addPercent(100);
			getProduct(10).addPercent(100);
			break;
		}
		case 2:
		{
			getProduct(6).addPercent(100);
			getProduct(7).addPercent(-500);
			getProduct(8).addPercent(100);
			getProduct(9).addPercent(0);
			getProduct(10).addPercent(100);
			break;
		}
		case 3:
		{
			getProduct(6).addPercent(0);
			getProduct(7).addPercent(100);
			getProduct(8).addPercent(0);
			getProduct(9).addPercent(0);
			getProduct(10).addPercent(0);
			break;
		}
		default:
			break;
		} 
		
		if(getAnswer(2) == 0)
		{
			getProduct(9).addPercent(-100);
		}
		
		if(getAnswer(3) == 0)
		{
			getProduct(8).addPercent(100);
		}
		
		if(getAnswer(4) == 3 ||getAnswer(4) == 4)
		{
			getProduct(10).addPercent(100);
		}				
	}
}

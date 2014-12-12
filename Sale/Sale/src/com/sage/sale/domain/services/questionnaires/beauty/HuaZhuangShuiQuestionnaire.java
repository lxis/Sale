package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.HuaZhuangShuiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class HuaZhuangShuiQuestionnaire extends BaseQuestionnaire<HuaZhuangShuiProductRepository> {

	public HuaZhuangShuiQuestionnaire() {
		super(HuaZhuangShuiProductRepository.class);
	}

	// "Pro-X White ���׷���ʽ���½��ʱ�ʪ�߻���ˮ",6 �� 340
	// "SK-II ����ˮ��SK-II ��������¶��",7 �� 1,040
	// "���� �滤��Ȫ����",8 �� 125
	// "��˿ ѩ������ױˮ",9 285
	// "��ʫ���� ȫ���������ɾ���ˮ����ˬ�ͣ�",10 360

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("���ر�ʪ�������ף�").addAnswer("��ʪ").addAnswer("����"));
		lists.add(new Question().setQuestion("�Ƿ�����Ƥ����").addAnswer("����").addAnswer("������"));
		lists.add(new Question().setQuestion("��������٣�").addAnswer("4000����").addAnswer("4000-8000").addAnswer("8000-16000").addAnswer("16000-32000").addAnswer("32000����"));
		lists.add(new Question().setQuestion("�Ƿ����з��ʣ�").addAnswer("������").addAnswer("������"));
		lists.add(new Question().setQuestion("�Ƿ����ƾ�ζ��").addAnswer("����").addAnswer("������"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41����"));
	}

	@Override
	protected void CalculateScore() {

		// �������ܼ�ֵ
		getProduct(6).addValue(100);
		getProduct(7).addValue(100);
		getProduct(8).addValue(100);
		getProduct(9).addValue(100);
		getProduct(10).addValue(100);

		// ȥ���۸�
		getProduct(6).addValue(-340);
		getProduct(7).addValue(-1040);
		getProduct(8).addValue(-125);
		getProduct(9).addValue(-285);
		getProduct(10).addValue(-360);

		// �����ֵ
		getProduct(6).addValue(100);
		getProduct(7).addValue(80);
		getProduct(8).addValue(60);
		getProduct(9).addValue(40);
		getProduct(10).addValue(20);

		double ps = 1;// priceSensitive
		switch (getAnswer(2)) {
		case 0:
			ps = 0.5;
			break;
		case 1:
			ps = 1;
			break;
		case 2:
			ps = 2;
			break;
		case 3:
			ps = 3;
			break;
		case 4:
			ps = 4;
			break;
		default:
			break;
		}

		if (getAnswer(0) == 0) {
			getProduct(6).addValue(200 * 0.75 * 0.5 * ps, "����").addValue(200 * 0.5 * 1 * ps, "��ʪ");
			getProduct(9).addValue(200 * 1 * 0.5 * ps, "����").addValue(200 * 0.5 * 1 * ps, "��ʪ");
			getProduct(10).addValue(200 * 1 * 1 * ps, "��ʪ");
		} else {
			getProduct(6).addValue(200 * 0.75 * 1 * ps, "����").addValue(200 * 0.5 * 0.5 * ps, "��ʪ");
			getProduct(9).addValue(200 * 1 * 1 * ps, "����").addValue(200 * 0.5 * 0.5 * ps, "��ʪ");
			getProduct(10).addValue(200 * 1 * 0.5 * ps, "��ʪ");
		}

		if (getAnswer(1) == 0) {
			getProduct(6).addValue(100 * 0.5 * ps, "ˮ��ƽ��");
			getProduct(7).addValue(100 * ps, "ˮ��ƽ��");
			getProduct(8).addValue(100 * ps, "ˮ��ƽ��");
			getProduct(9).addValue(100 * 0.25 * ps, "ˮ��ƽ��");
			getProduct(10).addValue(100 * ps, "ˮ��ƽ��");
		}

		if (getAnswer(3) == 0) {
			getProduct(7).addValue(300 * 1 * 1 * ps, "�ºͲ��̼�");
			getProduct(8).addValue(300 * 1 * 1 * ps, "�ºͲ��̼�");
		} else {
			getProduct(7).addValue(300 * 0.3 * 1 * ps, "�ºͲ��̼�");
			getProduct(8).addValue(300 * 0.3 * 1 * ps, "�ºͲ��̼�");

			getProduct(6).addValue(100 * 0.5 * 1 * ps, "������");
			getProduct(7).addValue(100 * 1 * 1 * ps, "������");
			getProduct(9).addValue(100 * 0.25 * 1 * ps, "������");
		}

		if (getAnswer(4) == 0) {
			getProduct(9).addValue(-200);
		}

		switch (getAnswer(5)) {
		case 0: {
			getProduct(7).addValue(400 * 0.75 * 0 * ps, "��˥��");
			getProduct(8).addValue(400 * 0.5 * 0 * ps, "��˥��");
			getProduct(10).addValue(400 * 0.5 * 0 * ps, "��˥��");
			break;
		}
		case 1: {
			getProduct(7).addValue(400 * 0.75 * 0.25 * ps, "��˥��");
			getProduct(8).addValue(400 * 0.5 * 0.25 * ps, "��˥��");
			getProduct(10).addValue(400 * 0.5 * 0.25 * ps, "��˥��");
			break;
		}
		case 2: {
			getProduct(7).addValue(400 * 0.75 * 0.5 * ps, "��˥��");
			getProduct(8).addValue(400 * 0.5 * 0.5 * ps, "��˥��");
			getProduct(10).addValue(400 * 0.5 * 0.5 * ps, "��˥��");
			break;
		}
		case 3: {
			getProduct(7).addValue(400 * 0.75 * 0.75 * ps, "��˥��");
			getProduct(8).addValue(400 * 0.5 * 0.75 * ps, "��˥��");
			getProduct(10).addValue(400 * 0.5 * 0.75 * ps, "��˥��");
			break;
		}
		case 4: {
			getProduct(7).addValue(400 * 0.75 * 1 * ps, "��˥��");
			getProduct(8).addValue(400 * 0.5 * 1 * ps, "��˥��");
			getProduct(10).addValue(400 * 0.5 * 1 * ps, "��˥��");
			break;
		}
		default:
			break;
		}
	}
}

package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.R;
import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire  implements IQuestionnaire {
	private ArrayList<Question> lists = new ArrayList<Question>();

	private int index = 0;	

	public MianMoQuestionnaire() {		
		GenerateQuestionnaire();
	}

	public Product getResult() {
		Product mi4Result = new Product("http://detail.tmall.com/item.htm?spm=a230r.1.14.1.ew7Ows&id=20005421504&abbucket=10", "����� ��ţԭҺ��Ĥ��",
				"http://gi2.md.alicdn.com/bao/uploaded/i2/TB1syFZGXXXXXc4aXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product mi3Result = new Product("http://detail.tmall.com/item.htm?spm=a230r.1.14.8.ew7Ows&id=20517144462&abbucket=10", "ˮ���̶��ཬ��Ĥ",
				"http://gi4.md.alicdn.com/bao/uploaded/i4/TB1xCsSGXXXXXcYaXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product hm1sResult = new Product("http://detail.tmall.com/item.htm?spm=a230r.1.14.23.ew7Ows&id=22101484185&abbucket=10",
				"BEELY«����ʪ��ˮ��Ĥ", "http://gi3.md.alicdn.com/bao/uploaded/i3/TB1OQ6iGVXXXXXdXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product hmNoteResult = new Product("http://detail.tmall.com/item.htm?spm=a230r.1.14.30.ew7Ows&id=41483139428&abbucket=10",
				"��ݮ�漣��Ĥ", "http://gi3.md.alicdn.com/bao/uploaded/i3/TB1d.xZGpXXXXceXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product iphone6Result = new Product("http://detail.tmall.com/item.htm?spm=a230r.1.14.37.ew7Ows&id=18785954277&abbucket=10",
				"��Ȫ�Ͱ��޻���Ĥ", "http://gi1.md.alicdn.com/bao/uploaded/i1/TB1saamGVXXXXXKXXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product iphone6PlusResult = new Product(
				"http://detail.tmall.com/item.htm?spm=a230r.1.14.45.ew7Ows&id=13898573818&abbucket=10", "JCare����ɽ������Ĥ",
				"http://gi2.md.alicdn.com/bao/uploaded/i2/TB11e8CGXXXXXcfXpXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");

		ArrayList<Product> results = new ArrayList<Product>();
		results.add(mi4Result);
		results.add(mi3Result);
		results.add(hm1sResult);
		results.add(hmNoteResult);
		results.add(iphone6Result);
		results.add(iphone6PlusResult);

		if (getAnswer(0) == 1) {
			iphone6Result.addPercent(50);
			iphone6PlusResult.addPercent(50);
		}

		switch (getAnswer(1)) {
		case 0: {
			hm1sResult.addPercent(100);
			hmNoteResult.addPercent(100);
			break;
		}
		case 1: {
			mi3Result.addPercent(100);
			mi4Result.addPercent(100);
			break;
		}
		case 2: {
			mi3Result.addPercent(100);
			mi4Result.addPercent(100);
			break;
		}
		case 3: {
			iphone6Result.addPercent(100);
			iphone6PlusResult.addPercent(100);
			break;
		}
		}

		if (getAnswer(2) == 1) {
			iphone6Result.addPercent(50);
			iphone6PlusResult.addPercent(50);
		}

		if (getAnswer(3) == 0) {
			mi4Result.addPercent(30);
			mi3Result.addPercent(30);
			hm1sResult.addPercent(30);
			iphone6Result.addPercent(30);
		} else {

			hmNoteResult.addPercent(30);
			iphone6PlusResult.addPercent(30);
		}
		if (getAnswer(4) == 1) {

			mi4Result.addPercent(20);
			iphone6Result.addPercent(50);
			iphone6PlusResult.addPercent(50);
		}

		int maxIndex = 0;
		for (int i = 1; i < results.size(); i++) {
			if (results.get(i).getPercent() > results.get(maxIndex)
					.getPercent())
				maxIndex = i;
		}
		return results.get(maxIndex);
	}

	private int getAnswer(int answerIndex) {
		return lists.get(answerIndex).getAnswer();
	}

	private void GenerateQuestionnaire() {

		Question q1 = new Question();
		q1.setQuestion("�������׻��ǲ�ˮ��");
		q1.addAnswer("����");
		q1.addAnswer("��ˮ");
		lists.add(q1);

		Question q2 = new Question();
		q2.setQuestion("Ԥ���ж��٣�");
		q2.addAnswer("100����");
		q2.addAnswer("100-200");
		q2.addAnswer("200-300");
		q2.addAnswer("300����");
		lists.add(q2);

		Question q3 = new Question();
		q3.setQuestion("�ǲ����ر���ʹ��ʱ�����");
		q3.addAnswer("�������");
		q3.addAnswer("�й�Ч����");
		lists.add(q3);

		Question q4 = new Question();
		q4.setQuestion("�Ƿ���Ҫ���ͣ�");
		q4.addAnswer("����Ҫ");
		q4.addAnswer("��û�ж���");
		lists.add(q4);

		Question q5 = new Question();
		q5.setQuestion("�����ǣ�");
		q5.addAnswer("С��20");
		q5.addAnswer("20-25");
		q5.addAnswer("25-30");
		q5.addAnswer("30-40");
		q5.addAnswer("40����");		
		lists.add(q5);
	}

	@Override
	public double getProgress() {
		return ((double)index)/((double)lists.size());
	}

	@Override
	public Question getQuestion() {
		if(index>=lists.size())
			return null;
		return lists.get(index);
	}

	@Override
	public void setAnswer(int answer) {
		lists.get(index).setAnswer(answer);
		index++;		
	}
}

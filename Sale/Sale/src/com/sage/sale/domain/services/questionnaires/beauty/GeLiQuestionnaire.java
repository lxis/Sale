package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire   implements IQuestionnaire {
	private ArrayList<Question> lists = new ArrayList<Question>();

	private int index = 0;	

	public GeLiQuestionnaire() {		
		GenerateQuestionnaire();
	}

	public Product getResult() {
		Product prox = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DoQng8XbMTNi6k0Or%252B%252BH4tLnFEATj2r0JZ6U672N6gVGLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9g4cqQEFfhVQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"���� ��ˬ������Я��ɹ��SPF30+��������ɹС��գ�",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1402/18/c0/31350206_1392706020017_400x400.jpg");
		Product skii = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DAciFMTFAQakjmraEDZVrLrBn3g4Xfww1MJ%252BJnhxioUmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe88LLEm%252F0ZUNw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"¶���� ����׶໤��ɹ��ҺSPF30+ PA+++��",
				"http://img.pclady.com.cn/images/pclady/brand/brand_logo/20125/14/13369827477916140_s3.jpg");
		Product yayang = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DPSjnSjBa5vYjmraEDZVrLqm8FfgKAJPqZCWWJYFETQiLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe94YabW06Rocg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"���� ����������׸���˪SPF26/PA++", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/11164/11164-1_500x500.jpg");
		Product kose = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3D4jFc4AjCG1XghojqVNxKsQKsPIKKBjdVZCWWJYFETQiLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9by8CuZGAp4g%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"¶���� ��͸��ɹ��SPF50", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/286/286-1_500x500.jpg");
		Product yashi = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DSPCIdCAIUzLebLdhAWchHHTg7JSXHrqGWUgXPn%252FBwdSLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252FFBKaW%252BSn9Jg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"�������� ���鼡͸��UV������Һ", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/94482/94482-1_500x500.jpg");

		ArrayList<Product> results = new ArrayList<Product>();
		results.add(prox);
		results.add(skii);
		results.add(yayang);
		results.add(kose);
		results.add(yashi);

		if (getAnswer(0) == 1) {
			yashi.addPercent(50);
		}

		switch (getAnswer(1)) {
		case 0: {
			yayang.addPercent(100);
			kose.addPercent(100);
			break;
		}
		case 1: {
			skii.addPercent(100);
			prox.addPercent(100);
			break;
		}
		case 2: {
			skii.addPercent(100);
			prox.addPercent(100);
			break;
		}
		case 3: {
			yashi.addPercent(100);
			break;
		}
		}

		if (getAnswer(2) == 1) {
			yashi.addPercent(50);
		}

		if (getAnswer(3) == 0) {
			prox.addPercent(30);
			skii.addPercent(30);
			yayang.addPercent(30);
			yashi.addPercent(30);
		} else {
			kose.addPercent(30);
		}
		if (getAnswer(4) == 1) {
			prox.addPercent(20);
			yashi.addPercent(50);
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

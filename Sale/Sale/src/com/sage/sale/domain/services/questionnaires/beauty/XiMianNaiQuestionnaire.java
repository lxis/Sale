package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire   implements IQuestionnaire {
	private ArrayList<Question> lists = new ArrayList<Question>();

	private int index = 0;	

	public XiMianNaiQuestionnaire() {		
		GenerateQuestionnaire();
	}

	public Product getResult() {
		Product prox = new Product("http://cosme.pclady.com.cn/product/66638.html", 
				"资生堂洗颜专科 柔澈泡沫洁面乳",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/66638/66638-5_500x500.jpg");
		Product skii = new Product("http://cosme.pclady.com.cn/product/12977.html", 
				"露得清 深层净化洗面乳）",
				"http://img.pclady.com.cn/images/pclady/brand/brand_logo/20124/23/13351733837274000_s3.jpg");
		Product yayang = new Product("http://cosme.pclady.com.cn/product/28468.html",
				"丝塔芙 洗面奶200ml", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/28468/28468-1_500x500.jpg");
		Product kose = new Product("http://cosme.pclady.com.cn/product/11192.html",
				"倩碧 液体洁面皂（温和型）", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/11192/11192-2_500x500.jpg");
		Product yashi = new Product("http://cosme.pclady.com.cn/product/12979.html",
				"露得清 深层柔珠洗面乳", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/12979/12979-1_500x500.jpg");

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
		q1.setQuestion("看重美白还是补水？");
		q1.addAnswer("美白");
		q1.addAnswer("补水");
		lists.add(q1);

		Question q2 = new Question();
		q2.setQuestion("预算有多少？");
		q2.addAnswer("100以内");
		q2.addAnswer("100-200");
		q2.addAnswer("200-300");
		q2.addAnswer("300以上");
		lists.add(q2);

		Question q3 = new Question();
		q3.setQuestion("是不是特别看重使用时舒服？");
		q3.addAnswer("必须舒服");
		q3.addAnswer("有功效就行");
		lists.add(q3);

		Question q4 = new Question();
		q4.setQuestion("是否需要控油？");
		q4.addAnswer("必须要");
		q4.addAnswer("有没有都行");
		lists.add(q4);

		Question q5 = new Question();
		q5.setQuestion("年龄是？");
		q5.addAnswer("小于20");
		q5.addAnswer("20-25");
		q5.addAnswer("25-30");
		q5.addAnswer("30-40");
		q5.addAnswer("40以上");		
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

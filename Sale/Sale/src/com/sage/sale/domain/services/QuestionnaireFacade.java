package com.sage.sale.domain.services;

import java.util.ArrayList;

import com.sage.sale.R;

public class QuestionnaireFacade implements IQuestionnaire {
	private ArrayList<Question> lists = new ArrayList<Question>();

	private int index = 0;

	public QuestionnaireFacade() {
		GenerateQuestionnaire();
	}

	public Product getResult() {
		Product mi4Result = new Product("http://www.mi.com/mi4", "小米4",
				R.drawable.mi4);
		Product mi3Result = new Product("http://www.mi.com/mi3", "小米3",
				R.drawable.mi3);
		Product hm1sResult = new Product("http://www.mi.com/hongmi1s4g",
				"红米1S", R.drawable.hm1s);
		Product hmNoteResult = new Product("http://www.mi.com/note4g",
				"红米Note", R.drawable.hm_note);
		Product iphone6Result = new Product("http://item.jd.com/1217505.html",
				"iPhone 6", R.drawable.iphone6);
		Product iphone6PlusResult = new Product(
				"http://item.jd.com/1217534.html", "iPhone 6 Plus",
				R.drawable.iphone6plus);

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
		q1.setQuestion("是否希望手机很有面子？");
		q1.addAnswer("是的");
		q1.addAnswer("无所谓");
		lists.add(q1);

		Question q2 = new Question();
		q2.setQuestion("预算有多少？");
		q2.addAnswer("1000以内");
		q2.addAnswer("1000-2000");
		q2.addAnswer("2000-3000");
		q2.addAnswer("3000以上");
		lists.add(q2);

		Question q3 = new Question();
		q3.setQuestion("是不是特别看重质量？");
		q3.addAnswer("能用一年就行");
		q3.addAnswer("需要能用很多年");
		lists.add(q3);

		Question q4 = new Question();
		q4.setQuestion("多大屏幕？");
		q4.addAnswer("正常屏幕");
		q4.addAnswer("喜欢特大的");
		lists.add(q4);

		Question q5 = new Question();
		q5.setQuestion("性别是？");
		q5.addAnswer("男");
		q5.addAnswer("女");
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

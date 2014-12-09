package com.sage.sale.domain.services.questionnaires.electric;

import java.util.ArrayList;

import com.sage.sale.R;
import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

public class TabletQuestionnaire implements IQuestionnaire {
	private ArrayList<Question> lists = new ArrayList<Question>();

	private int index = 0;	

	public TabletQuestionnaire() {		
		GenerateQuestionnaire();
	}

	public Product getResult() {
		Product ipadMini2 = new Product("http://item.jd.com/996967.html", "ipad mini 2",
				"http://img12.360buyimg.com/n1/jfs/t658/141/756273042/124759/34e9ae96/54857501N669802c6.jpg");
		Product ipadMini3 = new Product("http://item.jd.com/1250984.html", "ipad mini 3",
				"http://img14.360buyimg.com/n1/jfs/t613/13/593689949/128069/272a2bcc/547316faNbdf7f2a7.jpg");
		Product ipadAir2 = new Product("http://item.jd.com/1246836.html",
				"ipad air 2", "http://img11.360buyimg.com/n1/jfs/t568/83/593725239/161378/f4826f2/5473178bN94970d0b.jpg");
		Product ipadAir = new Product("http://item.jd.com/996961.html",
				"ipad air", "http://img11.360buyimg.com/n1/jfs/t535/107/565219241/137111/1d6bc020/547315c0N62971207.jpg");

		ArrayList<Product> results = new ArrayList<Product>();
		results.add(ipadMini2);
		results.add(ipadMini3);
		results.add(ipadAir2);
		results.add(ipadAir);

//
//
//		Question q2 = new Question();
//		q2.setQuestion("看重便携性还是观看体验？");
//		q2.addAnswer("便携");
//		q2.addAnswer("观看体验");
//		lists.add(q2);
		
		switch (getAnswer(0)) {
		case 0: {
			ipadAir2.addPercent(-150);
			ipadAir.addPercent(-100);
			ipadMini3.addPercent(-100);
			ipadMini2.addPercent(-50);
			break;
		}
		case 1: {
			ipadAir2.addPercent(-100);
			ipadAir.addPercent(-50);
			ipadMini3.addPercent(-50);
			ipadMini2.addPercent(0);
			break;
		}
		case 2: {
			ipadAir2.addPercent(-50);
			ipadAir.addPercent(50);
			ipadMini3.addPercent(50);
			ipadMini2.addPercent(0);
			break;
		}
		case 3: {
			ipadAir2.addPercent(50);
			ipadAir.addPercent(0);
			ipadMini3.addPercent(50);
			ipadMini2.addPercent(0);
			break;
		}
		}

		if (getAnswer(1) == 0) {

			ipadMini3.addPercent(50);
			ipadMini2.addPercent(50);
		} else {

			ipadAir2.addPercent(50);
			ipadAir.addPercent(50);
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
		q1.setQuestion("预算有多少？");
		
		q1.addAnswer("2000以内");
		q1.addAnswer("2000-2500");
		q1.addAnswer("2500-3000");
		q1.addAnswer("3000以上");
		lists.add(q1);


		Question q2 = new Question();
		q2.setQuestion("看重便携性还是观看体验？");
		q2.addAnswer("便携");
		q2.addAnswer("观看体验");
		lists.add(q2);
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

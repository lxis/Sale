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
		Product mi4Result = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DCDyxiOD0mzYjmraEDZVrLom4AoTBLPfFLOEkXoxPQQaLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9GdEF6li5fuw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"凯梵蒂 蜗牛原液面膜贴",
				"http://gi2.md.alicdn.com/bao/uploaded/i2/TB1syFZGXXXXXc4aXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product mi3Result = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DreA0rlimg7DebLdhAWchHO52MhFhb8tF1BHSvcRrnkWLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252FQFbze99L9mw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"水尚绿豆泥浆面膜",
				"http://gi4.md.alicdn.com/bao/uploaded/i4/TB1xCsSGXXXXXcYaXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product hm1sResult = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DZEs9Ap0RuTjebLdhAWchHHaFIg4N2e4YVBTWeYSeIzSLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9j%252Bk3C2VZgSQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"BEELY芦荟保湿补水面膜", 
				"http://gi3.md.alicdn.com/bao/uploaded/i3/TB1OQ6iGVXXXXXdXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product hmNoteResult = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3D8zJCNZ3UpSG6k0Or%252B%252BH4tA%252FGYH0KyAZpOHn0s68if2OLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252BSGPRyv2rnbw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"蓝莓奇迹面膜", 
				"http://gi3.md.alicdn.com/bao/uploaded/i3/TB1d.xZGpXXXXceXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product iphone6Result = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DOaeS9e67ZJXghojqVNxKsamheIjpzYgJKww%252BJCCRHnuLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9KvOGbBICiPA%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"皙肤泉萃白修护面膜", 
				"http://gi1.md.alicdn.com/bao/uploaded/i1/TB1saamGVXXXXXKXXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
		Product iphone6PlusResult = new Product(
				"http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DiUJUARJ0zsojmraEDZVrLu2g6rN6Nfj9LOEkXoxPQQaLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252B8%252F2Ztrwq1%252Bg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"JCare澳洲山羊奶面膜",
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

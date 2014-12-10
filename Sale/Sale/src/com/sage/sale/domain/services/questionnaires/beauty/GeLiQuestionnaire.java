package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire extends BaseQuestionnaire {


	public Product getResult() {
		Product prox = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DoQng8XbMTNi6k0Or%252B%252BH4tLnFEATj2r0JZ6U672N6gVGLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9g4cqQEFfhVQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"雅漾 清爽倍护便携防晒乳SPF30+（雅漾防晒小金刚）",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1402/18/c0/31350206_1392706020017_400x400.jpg");
		Product skii = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DAciFMTFAQakjmraEDZVrLrBn3g4Xfww1MJ%252BJnhxioUmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe88LLEm%252F0ZUNw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"露得清 活采皙白多护防晒乳液SPF30+ PA+++）",
				"http://img.pclady.com.cn/images/pclady/brand/brand_logo/20125/14/13369827477916140_s3.jpg");
		Product yayang = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DPSjnSjBa5vYjmraEDZVrLqm8FfgKAJPqZCWWJYFETQiLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe94YabW06Rocg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"姬芮 新能真皙美白隔离霜SPF26/PA++", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/11164/11164-1_500x500.jpg");
		Product kose = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3D4jFc4AjCG1XghojqVNxKsQKsPIKKBjdVZCWWJYFETQiLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9by8CuZGAp4g%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"露得清 轻透防晒乳SPF50", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/286/286-1_500x500.jpg");
		Product yashi = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DSPCIdCAIUzLebLdhAWchHHTg7JSXHrqGWUgXPn%252FBwdSLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252FFBKaW%252BSn9Jg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"法国娇兰 珍珠肌透白UV隔离乳液", 
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


	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("看重美白还是补水？").addAnswer("美白").addAnswer("补水"));
		lists.add(new Question().setQuestion("预算有多少？").addAnswer("100以内").addAnswer("100-200").addAnswer("200-300").addAnswer("300以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否需要控油？").addAnswer("必须要").addAnswer("有没有都行"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("20-25").addAnswer("25-30").addAnswer("30-40").addAnswer("40以上"));
	}
}

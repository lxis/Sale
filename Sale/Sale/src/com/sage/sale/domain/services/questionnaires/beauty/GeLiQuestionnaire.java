package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.GeLiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire extends BaseQuestionnaire<GeLiProductRepository> {

	public GeLiQuestionnaire() {
		super(GeLiProductRepository.class);
	}

	// "雅漾 清爽倍护便携防晒乳SPF30+（雅漾防晒小金刚）",1 646
	// "露得清 活采皙白多护防晒乳液SPF30+ PA+++）",2 332
	// "姬芮 新能真皙美白隔离霜SPF26/PA++",3 79
	// "露得清 轻透防晒乳SPF50",4 79
	// "法国娇兰 珍珠肌透白UV隔离乳液", 5 787

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("防晒倍数是否必须50的？").addAnswer("是").addAnswer("不是"));
		lists.add(new Question().setQuestion("预算有多少（规格按50ML计算）？").addAnswer("100以内").addAnswer("100-200").addAnswer("200-400").addAnswer("400以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时清爽？").addAnswer("必须清爽").addAnswer("功效好就行，可以稍油腻"));		
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {
		
		//本身价值
		getProduct(1).addPercent(100).addMatch("销量冠军");
		getProduct(2).addPercent(80).addMatch("销量领先",9);
		getProduct(3).addPercent(60).addMatch("销量领先",9);
		getProduct(4).addPercent(40);
		getProduct(5).addPercent(20);
		
		if(getAnswer(0)==0)
		{
			getProduct(0).addMatch("高倍防晒");
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
			getProduct(1).addPercent(100).addMatch("清爽不油腻",9);
			getProduct(2).addPercent(100).addMatch("清爽不油腻",9);
			getProduct(3).addPercent(100).addMatch("清爽不油腻",9);			
		}
	}
}

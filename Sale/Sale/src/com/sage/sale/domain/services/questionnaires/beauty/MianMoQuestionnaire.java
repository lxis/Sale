package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.MianMoProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire extends BaseQuestionnaire<MianMoProductRepository> {

	public MianMoQuestionnaire() {
		super(MianMoProductRepository.class);
	}

	// "巴黎欧莱雅 肌底透白彻夜焕采冻膜",11 109
	// "悦木之源 水润畅饮夜间密集滋养面膜",12 320
	// "水芝澳 面部绿洲夜间密集补水面膜(晚安面膜)",13 1000
	// "茱莉蔻 玫瑰衡肤水润面膜",14 380
	// "娇韵诗 恒润保湿面膜",15 480

	protected void GenerateQuestionnaire() {
		
		lists.add(new Question().setQuestion("预算有多少（规格按100ML计算）？").addAnswer("200以内").addAnswer("200-400").addAnswer("400-800").addAnswer("800以上"));
		lists.add(new Question().setQuestion("是不是特别看重清爽？").addAnswer("必须清爽").addAnswer("稍油点没关系"));
		lists.add(new Question().setQuestion("是否容易过敏？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {
		
		//本身价值
		getProduct(11).addValue(100);
		getProduct(12).addValue(80);
		getProduct(13).addValue(60);
		getProduct(14).addValue(40);
		getProduct(15).addValue(20);
		
		switch (getAnswer(0)) {
		case 0: {
			getProduct(11).addValue(100);
			getProduct(12).addValue(-200);
			getProduct(13).addValue(-1000);
			getProduct(14).addValue(-200);
			getProduct(15).addValue(-500);
			break;
		}
		case 1: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(100);
			getProduct(13).addValue(-750);
			getProduct(14).addValue(100);
			getProduct(15).addValue(-100);
			break;
		}
		case 2: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(0);
			getProduct(13).addValue(-500);
			getProduct(14).addValue(0);
			getProduct(15).addValue(100);
			break;
		}
		case 3: {
			getProduct(11).addValue(0);
			getProduct(12).addValue(0);
			getProduct(13).addValue(100);
			getProduct(14).addValue(0);
			getProduct(15).addValue(0);
			break;
		}
		default:
			break;
		}		
		
		if(getAnswer(1)==0)
		{
			getProduct(12).addValue(-100);
		}
		
		if(getAnswer(2)==0)
		{
			getProduct(11).addValue(-100);
		}
		
		switch (getAnswer(3)) {
		case 0:
		case 1:
		{
			getProduct(13).addValue(100,"温和");
			getProduct(15).addValue(100,"温和");
			
			break;
		}
		case 2:
		case 3:
		{
			getProduct(11).addValue(100,"抗衰老");
			getProduct(12).addValue(100,"抗衰老");
			getProduct(14).addValue(100,"抗衰老");
			break;
		}
		default:
			break;
		}
		

	}
}

package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.MianMoProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire extends BaseQuestionnaire<MianMoProductRepository>{


	public MianMoQuestionnaire() {
		super(MianMoProductRepository.class);
	}	
	
	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(12).addPercent(50);
		}		
	}

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("看重美白还是补水？").addAnswer("美白").addAnswer("补水"));
		lists.add(new Question().setQuestion("预算有多少？").addAnswer("100以内").addAnswer("100-200").addAnswer("200-300").addAnswer("300以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否需要控油？").addAnswer("必须要").addAnswer("有没有都行"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("20-25").addAnswer("25-30").addAnswer("30-40").addAnswer("40以上"));
	}
}

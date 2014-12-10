package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.MianMoProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class MianMoQuestionnaire extends BaseQuestionnaire<MianMoProductRepository> {

	public MianMoQuestionnaire() {
		super(MianMoProductRepository.class);
	}
	
//			"巴黎欧莱雅 肌底透白彻夜焕采冻膜",11
//			"悦木之源 水润畅饮夜间密集滋养面膜",12
//			"水芝澳 面部绿洲夜间密集补水面膜(晚安面膜)",13
//			"茱莉蔻 玫瑰衡肤水润面膜",14
//			"娇韵诗 恒润保湿面膜",15

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("美白功能是否特别重要？").addAnswer("非常重要").addAnswer("一般重要"));
		lists.add(new Question().setQuestion("预算有多少（规格按150ML计算）？").addAnswer("200以内").addAnswer("200-400").addAnswer("400-800").addAnswer("800以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否容易过敏？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(12).addPercent(50);
		}
	}
}

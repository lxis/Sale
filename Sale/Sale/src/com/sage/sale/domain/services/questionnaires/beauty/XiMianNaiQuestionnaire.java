package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.XiMianNaiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire extends BaseQuestionnaire<XiMianNaiProductRepository> {

	public XiMianNaiQuestionnaire() {
		super(XiMianNaiProductRepository.class);
	}

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
			productRepository.getProduct(17).addPercent(50);
		}
	}
}

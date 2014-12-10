package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.GeLiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class GeLiQuestionnaire extends BaseQuestionnaire<GeLiProductRepository> {

	public GeLiQuestionnaire() {
		super(GeLiProductRepository.class);
	}		
	
//	"雅漾 清爽倍护便携防晒乳SPF30+（雅漾防晒小金刚）",1 646
//	"露得清 活采皙白多护防晒乳液SPF30+ PA+++）",2 332
//	"姬芮 新能真皙美白隔离霜SPF26/PA++",3 79
//	"露得清 轻透防晒乳SPF50",4 79
//	"法国娇兰 珍珠肌透白UV隔离乳液", 5		 787

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("美白功能是否特别重要？").addAnswer("非常重要").addAnswer("一般重要"));
		lists.add(new Question().setQuestion("预算有多少（规格按50ML计算）？").addAnswer("100以内").addAnswer("100-200").addAnswer("200-400").addAnswer("400以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否容易过敏？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {
		if (getAnswer(0) == 1) {
			productRepository.getProduct(4).addPercent(50);
		}		
	}
}

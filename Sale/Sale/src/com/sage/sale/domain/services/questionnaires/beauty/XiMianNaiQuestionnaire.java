package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.XiMianNaiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire extends BaseQuestionnaire<XiMianNaiProductRepository> {

	public XiMianNaiQuestionnaire() {
		super(XiMianNaiProductRepository.class);
	}
	
	
//			"资生堂洗颜专科 柔澈泡沫洁面乳",17 56
//			"露得清 深层净化洗面乳）",18 36
//			"丝塔芙 洗面奶200ml",19 81
//			"倩碧 液体洁面皂（温和型）",20 150
//			"露得清 深层柔珠洗面乳",21		 36

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("是否油性皮肤？").addAnswer("是").addAnswer("不是"));
		lists.add(new Question().setQuestion("预算有多少（规格按150ML计算）？").addAnswer("50以内").addAnswer("50-100").addAnswer("100-200").addAnswer("200以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否容易过敏？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {
		//本身价值
		getProduct(17).addPercent(100);
		getProduct(18).addPercent(80);
		getProduct(19).addPercent(60);
		getProduct(20).addPercent(40);
		getProduct(21).addPercent(20);
		
		
		if(getAnswer(0)==0)
		{
			getProduct(17).addPercent(100);
			getProduct(18).addPercent(100);
		}
		
		switch (getAnswer(1)) {
		case 0:
		{
			getProduct(17).addPercent(100);
			getProduct(18).addPercent(100);
			getProduct(19).addPercent(-100);
			getProduct(20).addPercent(-300);
			getProduct(21).addPercent(100);
			break;
		}
		case 1:
		{
			getProduct(17).addPercent(0);
			getProduct(18).addPercent(0);
			getProduct(19).addPercent(100);
			getProduct(20).addPercent(-200);
			getProduct(21).addPercent(0);
			break;
		}
		case 2:
		{
			getProduct(17).addPercent(0);
			getProduct(18).addPercent(0);
			getProduct(19).addPercent(0);
			getProduct(20).addPercent(100);
			getProduct(21).addPercent(0);
			break;
		}
		default:
			break;
		} 
		
		if(getAnswer(2)==0)
		{
			getProduct(18).addPercent(-100);
		}
		
		if(getAnswer(3)==0)
		{
			getProduct(19).addPercent(100);
			getProduct(20).addPercent(100);
		}						
	}
}

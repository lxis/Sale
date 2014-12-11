package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.HuaZhuangShuiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class HuaZhuangShuiQuestionnaire extends BaseQuestionnaire<HuaZhuangShuiProductRepository> {

	public HuaZhuangShuiQuestionnaire() {
		super(HuaZhuangShuiProductRepository.class);
	}	
//			"Pro-X White 纯白方程式更新角质保湿高机能水",6  ￥ 340      
//			"SK-II 神仙水（SK-II 护肤精华露）",7  ￥ 1,040
//			"雅漾 舒护活泉喷雾",8  ￥ 125
//			"高丝 雪肌精化妆水",9   285
//			"雅诗兰黛 全新鲜亮焕采精粹水（清爽型）",10   360

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("美白功能是否特别重要？").addAnswer("非常重要").addAnswer("一般重要"));
		lists.add(new Question().setQuestion("预算有多少（规格按150ML计算）？").addAnswer("200以内").addAnswer("200-400").addAnswer("400-800").addAnswer("800以上"));
		lists.add(new Question().setQuestion("是不是特别看重使用时舒服？").addAnswer("必须舒服").addAnswer("有功效就行"));
		lists.add(new Question().setQuestion("是否容易过敏？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	
	
	@Override
	protected void CalculateScore() {
		//本身价值
		getProduct(6).addPercent(100).addMatch("销量冠军").addMatch("不刺激").addMatch("无酒精");
		getProduct(7).addPercent(80).addMatch("销量领先");
		getProduct(8).addPercent(60).addMatch("销量领先");
		getProduct(9).addPercent(40);
		getProduct(10).addPercent(20);
		
		if(getAnswer(0)==0)
		{
			getProduct(6).addPercent(100);
			getProduct(9).addPercent(100);
		}
		
		switch (getAnswer(1)) {
		case 0:
		{
			getProduct(6).addPercent(-300);
			getProduct(7).addPercent(-1000);
			getProduct(8).addPercent(200);
			getProduct(9).addPercent(-100);
			getProduct(10).addPercent(-300);
			break;
		}
		case 1:
		{
			getProduct(6).addPercent(100);
			getProduct(7).addPercent(-300);
			getProduct(8).addPercent(0);
			getProduct(9).addPercent(100);
			getProduct(10).addPercent(100);
			break;
		}
		case 2:
		{
			getProduct(6).addPercent(100);
			getProduct(7).addPercent(-500);
			getProduct(8).addPercent(100);
			getProduct(9).addPercent(0);
			getProduct(10).addPercent(100);
			break;
		}
		case 3:
		{
			getProduct(6).addPercent(0);
			getProduct(7).addPercent(100);
			getProduct(8).addPercent(0);
			getProduct(9).addPercent(0);
			getProduct(10).addPercent(0);
			break;
		}
		default:
			break;
		} 
		
		if(getAnswer(2) == 0)
		{
			getProduct(9).addPercent(-100);
		}
		
		if(getAnswer(3) == 0)
		{
			getProduct(8).addPercent(100);
		}
		
		if(getAnswer(4) == 3 ||getAnswer(4) == 4)
		{
			getProduct(10).addPercent(100);
		}				
	}
}

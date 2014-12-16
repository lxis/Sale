package com.sage.sale.domain.services.questionnaires.beauty;

import com.sage.sale.domain.services.products.beauty.HuaZhuangShuiProductRepository;
import com.sage.sale.domain.services.questionnaires.Question;

public class HuaZhuangShuiQuestionnaire extends BaseQuestionnaire<HuaZhuangShuiProductRepository> {

	public HuaZhuangShuiQuestionnaire() {
		super(HuaZhuangShuiProductRepository.class);
	}

	// "Pro-X White 纯白方程式更新角质保湿高机能水",6 ￥ 340
	// "SK-II 神仙水（SK-II 护肤精华露）",7 ￥ 1,040
	// "雅漾 舒护活泉喷雾",8 ￥ 125
	// "高丝 雪肌精化妆水",9 285
	// "雅诗兰黛 全新鲜亮焕采精粹水（清爽型）",10 360

	protected void GenerateQuestionnaire() {
		lists.add(new Question().setQuestion("看重保湿还是美白？").addAnswer("保湿").addAnswer("美白"));
		lists.add(new Question().setQuestion("是否油性皮肤？").addAnswer("油性").addAnswer("非油性"));
		lists.add(new Question().setQuestion("月收入多少？").addAnswer("4000以内").addAnswer("4000-8000").addAnswer("8000-16000").addAnswer("16000-32000").addAnswer("32000以上"));
		lists.add(new Question().setQuestion("是否敏感肤质？").addAnswer("很敏感").addAnswer("不敏感"));
		lists.add(new Question().setQuestion("是否介意酒精味？").addAnswer("介意").addAnswer("不介意"));
		lists.add(new Question().setQuestion("年龄是？").addAnswer("小于20").addAnswer("21-25").addAnswer("26-30").addAnswer("31-40").addAnswer("41以上"));
	}

	@Override
	protected void CalculateScore() {

		// 基本功能价值
		getProduct(6).addValue(100);
		getProduct(7).addValue(100);
		getProduct(8).addValue(100);
		getProduct(9).addValue(100);
		getProduct(10).addValue(100);

		// 去除价格
		getProduct(6).setPrice(340);
		getProduct(7).setPrice(1040);
		getProduct(8).setPrice(125);
		getProduct(9).setPrice(285);
		getProduct(10).setPrice(360);

		// 本身价值
		getProduct(6).addValue(100);
		getProduct(7).addValue(80);
		getProduct(8).addValue(60);
		getProduct(9).addValue(40);
		getProduct(10).addValue(20);

		double ps = 1;// priceSensitive
		switch (getAnswer(2)) {
		case 0:
			ps = 0.5;
			break;
		case 1:
			ps = 1;
			break;
		case 2:
			ps = 2;
			break;
		case 3:
			ps = 3;
			break;
		case 4:
			ps = 4;
			break;
		default:
			break;
		}

		if (getAnswer(0) == 0) {
			getProduct(6).addValue(200 * 0.75 * 0.5 * ps, "美白", "美白性好，在同类产品中属于优秀").addValue(200 * 0.5 * 1 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
			getProduct(9).addValue(200 * 1 * 0.5 * ps, "美白", "美白性好，在同类产品中属于优秀").addValue(200 * 0.5 * 1 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
			getProduct(10).addValue(200 * 1 * 1 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
		} else {
			getProduct(6).addValue(200 * 0.75 * 1 * ps, "美白", "美白性好，在同类产品中属于优秀").addValue(200 * 0.5 * 0.5 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
			getProduct(9).addValue(200 * 1 * 1 * ps, "美白", "美白性好，在同类产品中属于优秀").addValue(200 * 0.5 * 0.5 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
			getProduct(10).addValue(200 * 1 * 0.5 * ps, "保湿", "保湿性能较好，能迅速补充肌肤水份。");
		}

		if (getAnswer(1) == 0) {
			getProduct(6).addValue(100 * 0.5 * ps, "水油平衡", "使用控制水油平衡，肤质有明显改善.");
			getProduct(7).addValue(100 * ps, "水油平衡", "使用控制水油平衡，肤质有明显改善.");
			getProduct(8).addValue(100 * ps, "水油平衡", "使用控制水油平衡，肤质有明显改善.");
			getProduct(9).addValue(100 * 0.25 * ps, "水油平衡", "使用控制水油平衡，肤质有明显改善.");
			getProduct(10).addValue(100 * ps, "水油平衡", "使用控制水油平衡，肤质有明显改善.");
		}

		if (getAnswer(3) == 0) {
			getProduct(7).addValue(300 * 1 * 1 * ps, "温和不刺激", "可显著地减轻肌肤由于受到各种刺激而产生的反应现象");
			getProduct(8).addValue(300 * 1 * 1 * ps, "温和不刺激", "可显著地减轻肌肤由于受到各种刺激而产生的反应现象");
		} else {
			getProduct(7).addValue(300 * 0.3 * 1 * ps, "温和不刺激", "可显著地减轻肌肤由于受到各种刺激而产生的反应现象");
			getProduct(8).addValue(300 * 0.3 * 1 * ps, "温和不刺激", "可显著地减轻肌肤由于受到各种刺激而产生的反应现象");

			getProduct(6).addValue(100 * 0.5 * 1 * ps, "软化角质", "能温和地清除老化角质细胞，并促进肌肤的新陈代谢。");
			getProduct(7).addValue(100 * 1 * 1 * ps, "软化角质", "能温和地清除老化角质细胞，并促进肌肤的新陈代谢。");
			getProduct(9).addValue(100 * 0.25 * 1 * ps, "软化角质", "能温和地清除老化角质细胞，并促进肌肤的新陈代谢。");
		}

		if (getAnswer(4) == 0) {
			getProduct(9).addValue(-200);
		}

		switch (getAnswer(5)) {
		case 0: {
			getProduct(7).addValue(300 * 0.75 * 0 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(8).addValue(300 * 0.5 * 0 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(10).addValue(300 * 0.5 * 0 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			break;
		}
		case 1: {
			getProduct(7).addValue(300 * 0.75 * 0.25 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(8).addValue(300 * 0.5 * 0.25 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(10).addValue(300 * 0.5 * 0.25 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			break;
		}
		case 2: {
			getProduct(7).addValue(300 * 0.75 * 0.5 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(8).addValue(300 * 0.5 * 0.5 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(10).addValue(300 * 0.5 * 0.5 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			break;
		}
		case 3: {
			getProduct(7).addValue(300 * 0.75 * 0.75 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(8).addValue(300 * 0.5 * 0.75 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(10).addValue(300 * 0.5 * 0.75 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			break;
		}
		case 4: {
			getProduct(7).addValue(300 * 0.75 * 1 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(8).addValue(300 * 0.5 * 1 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			getProduct(10).addValue(300 * 0.5 * 1 * ps, "抗衰老", "可帮助抵抗自由基，预防肌肤老化现象,减淡细纹及皱纹");
			break;
		}
		default:
			break;
		}
	}
}

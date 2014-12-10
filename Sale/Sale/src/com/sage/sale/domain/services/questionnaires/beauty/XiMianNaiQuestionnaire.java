package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.Question;

public class XiMianNaiQuestionnaire  extends BaseQuestionnaire {


	public Product getResult() {
		Product prox = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DpicRogIj6J3ghojqVNxKsQO7rSEMGMPvsMiqaJ97LhaLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe%252FVb5j0o418lQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"������ϴ��ר�� �ᳺ��ĭ������",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/66638/66638-5_500x500.jpg");
		Product skii = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3D9K1J2qFu7ecjmraEDZVrLu42ZTms8J2zMJ%252BJnhxioUmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe8ISMbcN4pDQw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"¶���� ��㾻��ϴ���飩",
				"http://img.pclady.com.cn/images/pclady/brand/brand_logo/20124/23/13351733837274000_s3.jpg");
		Product yayang = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3Dl1XXSx%252FZ21m6k0Or%252B%252BH4tO7TjA7ic8y6nnDOe2U0TNmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9oVICaWu9jmA%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"˿��ܽ ϴ����200ml", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/28468/28468-1_500x500.jpg");
		Product kose = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DTUj63kbGF2W6k0Or%252B%252BH4tEmNa%252BWlFibRYWWSgzdtn6mLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9kfZCoCkqiDw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"ٻ�� Һ��������º��ͣ�", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/11192/11192-2_500x500.jpg");
		Product yashi = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3Dzc8kcC83sGMjmraEDZVrLpGMbkeQyoes%252FgRj6p39QSeLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe8WLr7gcbaS6w%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"¶���� �������ϴ����", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/12979/12979-1_500x500.jpg");

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

		Question q1 = new Question();
		q1.setQuestion("�������׻��ǲ�ˮ��");
		q1.addAnswer("����");
		q1.addAnswer("��ˮ");
		lists.add(q1);

		Question q2 = new Question();
		q2.setQuestion("Ԥ���ж��٣�");
		q2.addAnswer("100����");
		q2.addAnswer("100-200");
		q2.addAnswer("200-300");
		q2.addAnswer("300����");
		lists.add(q2);

		Question q3 = new Question();
		q3.setQuestion("�ǲ����ر���ʹ��ʱ�����");
		q3.addAnswer("�������");
		q3.addAnswer("�й�Ч����");
		lists.add(q3);

		Question q4 = new Question();
		q4.setQuestion("�Ƿ���Ҫ���ͣ�");
		q4.addAnswer("����Ҫ");
		q4.addAnswer("��û�ж���");
		lists.add(q4);

		Question q5 = new Question();
		q5.setQuestion("�����ǣ�");
		q5.addAnswer("С��20");
		q5.addAnswer("20-25");
		q5.addAnswer("25-30");
		q5.addAnswer("30-40");
		q5.addAnswer("40����");		
		lists.add(q5);
	}
}

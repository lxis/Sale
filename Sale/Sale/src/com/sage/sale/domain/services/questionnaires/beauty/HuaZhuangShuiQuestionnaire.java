package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.Question;

public class HuaZhuangShuiQuestionnaire  extends BaseQuestionnaire{


	public Product getResult() {
		Product prox = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DI1%252F92KrXEAYjmraEDZVrLjg6uUqAQ%252Bjx3G1s8WRbfpWLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252Bi3aFqZPZa9dVo3WvHOZm5A%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"Pro-X White ���׷���ʽ���½��ʱ�ʪ�߻���ˮ",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/95015/95015-5_500x500.jpg");
		Product skii = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DPXS9eOWs7GbghojqVNxKsSzg%252BuK0rubhbh4mOrg73nmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252Bi3aFqZPZa9f%252B7C3QHBbSdQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068", 
				"SK-II ����ˮ��SK-II ��������¶��",
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/1682/1682-1_500x500.jpg");
		Product yayang = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3Dh6%252FV6b1ryT8jmraEDZVrLksZBX%252BwYAfQ3G1s8WRbfpWLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe9QkzqjaUrswA%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"���� �滤��Ȫ����", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1402/12/c0/31189803_1392187832230_400x400.jpg");
		Product kose = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DWTPkbqcAxs3ghojqVNxKsV8SyO3xc7xDN6QO%252Bdd6jj6LltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252Bi3aFqZPZa9cYMvJ8itdRfg%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"��˿ ѩ������ױˮ", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1311/11/zz/2263/2263-4_500x500.jpg");
		Product yashi = new Product("http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3DTLPE36YwC0m6k0Or%252B%252BH4tCoGd%252BDKX1LLbh4mOrg73nmLltG5xFicOdXrTUTgh9sMDPIwxrc30rgx5xFFx04TdSznQSvJ8jguXAYRM2Y%252BniwwzXBeaT5xzlRmtaud%252B0v%252B0B6QeGMsXe8nPM1nRk%252FQtw%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_106624709_8422695_28408068",
				"��ʫ���� ȫ���������ɾ���ˮ����ˬ�ͣ�", 
				"http://img.pconline.com.cn/images/upload/upc/tx/lady_cosme/1305/03/c0/20509818_1367568227596_400x400.jpg");

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

		lists.add(new Question().setQuestion("�������׻��ǲ�ˮ��").addAnswer("����").addAnswer("��ˮ"));
		lists.add(new Question().setQuestion("Ԥ���ж��٣�").addAnswer("100����").addAnswer("100-200").addAnswer("200-300").addAnswer("300����"));
		lists.add(new Question().setQuestion("�ǲ����ر���ʹ��ʱ�����").addAnswer("�������").addAnswer("�й�Ч����"));
		lists.add(new Question().setQuestion("�Ƿ���Ҫ���ͣ�").addAnswer("����Ҫ").addAnswer("��û�ж���"));
		lists.add(new Question().setQuestion("�����ǣ�").addAnswer("С��20").addAnswer("20-25").addAnswer("25-30").addAnswer("30-40").addAnswer("40����"));
	}
}

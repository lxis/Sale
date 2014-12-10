package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;
import com.sage.sale.domain.services.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

//这个类不是很稳定的，根据业务变化会很快不一样。但它实现的IQuestionnaire是稳定的
public abstract class BaseQuestionnaire   implements IQuestionnaire {
	protected ArrayList<Question> lists = new ArrayList<Question>();

	protected int index = 0;	

	public BaseQuestionnaire() {		
		GenerateQuestionnaire();
	}

	public Product getResult() {
		throw new RuntimeException("未实现");
	}

	protected int getAnswer(int answerIndex) {
		return lists.get(answerIndex).getAnswer();
	}

	protected abstract void GenerateQuestionnaire(); 

	@Override
	public double getProgress() {
		return ((double)index)/((double)lists.size());
	}

	@Override
	public Question getQuestion() {
		if(index>=lists.size())
			return null;
		return lists.get(index);
	}

	@Override
	public void setAnswer(int answer) {
		lists.get(index).setAnswer(answer);
		index++;		
	}
}

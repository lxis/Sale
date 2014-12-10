package com.sage.sale.domain.services.questionnaires.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.beauty.BaseProductRepository;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;

//这个类不是很稳定的，根据业务变化会很快不一样。但它实现的IQuestionnaire是稳定的
public abstract class BaseQuestionnaire<T extends BaseProductRepository>   implements IQuestionnaire {
	protected ArrayList<Question> lists = new ArrayList<Question>();
	protected T  productRepository;
	protected int index = 0;	

	public BaseQuestionnaire(Class<T> classType) {
		try {
			productRepository = classType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		GenerateQuestionnaire();				
	}

	public Product getResult() {			
		CalculateScore();
		int maxIndex = 0;
		for (int i = 1; i < productRepository.getProducts().size(); i++) {
			if (productRepository.getProducts().get(i).getPercent() > productRepository.getProducts().get(maxIndex)
					.getPercent())
				maxIndex = i;
		}
		return productRepository.getProducts().get(maxIndex);		
	}

	protected abstract void CalculateScore() ;

	protected int getAnswer(int answerIndex) {
		return lists.get(answerIndex).getAnswer();
	}
	
	protected Product getProduct(int id) {
		return productRepository.getProduct(id);
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

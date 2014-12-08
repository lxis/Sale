package com.sage.sale.domain.services.questionnaires;

import com.sage.sale.domain.services.Product;


public interface IQuestionnaire {

	Product getResult();

	Question getQuestion();

	double getProgress();
	
	void setAnswer(int answer);
}

package com.sage.sale.domain.services;


public interface IQuestionnaire {

	Product getResult();

	Question getQuestion();

	double getProgress();
	
	void setAnswer(int answer);
}

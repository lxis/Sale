package com.sage.sale.domain.services.questionnaires;

import java.util.ArrayList;

public class Question {
	
	private String question;
	private ArrayList<String> answers = new ArrayList<String>();
	private int answer;
	
	public String getQuestion() {
		return question;
	}
	public Question setQuestion(String question) {
		this.question = question;
		return this;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public Question addAnswer(String answer)
	{
		answers.add(answer);
		return this;
	}		
}

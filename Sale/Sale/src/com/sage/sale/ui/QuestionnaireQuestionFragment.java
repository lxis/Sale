package com.sage.sale.ui;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sage.sale.R;
import com.sage.sale.domain.services.questionnaires.Question;

public class QuestionnaireQuestionFragment extends Fragment {

	LayoutInflater inflater;
	QuestionnaireActivity activity;
	View fragment;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		fragment = inflater.inflate(R.layout.questionnaire_question_control, container, false);	
		activity = (QuestionnaireActivity)getActivity();	
		showQuestion();		
		return fragment;
	}
	
	public void showQuestion() {
		Question question = activity.questionnaire.getQuestion();
		String questionText = question.getQuestion();

		View findedView = fragment.findViewById(R.id.textViewQuestion);
		((TextView)findedView ).setText(questionText);
		((LinearLayout) fragment.findViewById(R.id.answerLayout)).removeAllViews();
		ArrayList<String> answers = question.getAnswers();
		for (int i = 0; i < answers.size(); i++)
			addAnswer(answers.get(i), i);
		ProgressBar progressBarProgress = (ProgressBar) fragment.findViewById(R.id.progressBarProgress);
		progressBarProgress.setMax(100);
		progressBarProgress.setProgress((int) (activity.questionnaire.getProgress() * 100));
		activity.showWithAnimation(fragment.findViewById(R.id.linearLayoutQuestionContent));

	}
	
	void addAnswer(String answer, final int index) {
		View view = getAnswerTextView();
		TextView textView = ((TextView) view.findViewById(R.id.textViewAnswer));
		textView.setText(answer);
		textView.setOnClickListener(getMoveNextClickListener(index));
		((LinearLayout) fragment.findViewById(R.id.answerLayout)).addView(view, getAnswerTextViewLayoutParam());
	}
	
	private View getAnswerTextView() {
		return inflater.inflate(R.layout.questionnaire_question_answer_control, null);
	}

	private LinearLayout.LayoutParams getAnswerTextViewLayoutParam() {
		LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		return layoutParam;
	}
	
	OnClickListener getMoveNextClickListener(final int index) {
		return new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				arg0.setOnClickListener(null);
				setAnswer(index);
			}
		};
	}
	
	private void setAnswer(final int index) {
		activity.questionnaire.setAnswer(index);
		activity.hideWithAnimation(fragment.findViewById(R.id.linearLayoutQuestionContent), new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (activity.questionnaire.getQuestion() == null)
				{
					activity.generateAndShowResult();
				}
				else
				{
					showQuestion();
				}
			}
		});

	}
}

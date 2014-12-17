package com.sage.sale.ui;

import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;
import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.QuestionnaireFactory;

public class QuestionnaireActivity extends FragmentActivity {

	// ȫ����ҵ�����ݶ�����
	IQuestionnaire questionnaire;
	Category category;
	QuestionnaireQuestionFragment fragmentQuestion;
	QuestionnaireResultFragment fragmentResult;
	Product testedProduct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.questionnaire_activity);

		String categoryJson = getIntent().getStringExtra("Category");
		category = new Gson().fromJson(categoryJson, CategorySerializeHelper.class).getCategory();
		questionnaire = new QuestionnaireFactory().getQuestionnaire(category);

		testedProduct = category.getTestedResult(this);
		if (testedProduct == null) {
			addQuestionnaireQuestion();
		} else {
			createFragmentAndshowResult(testedProduct);
		}
	}

	private void addQuestionnaireQuestion() {
		fragmentQuestion = new QuestionnaireQuestionFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentQuestion).commit();
	}

	void restart() {
		hideWithAnimation(findViewById(R.id.resultLayout), new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				fragmentQuestion = new QuestionnaireQuestionFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentQuestion).commit();

				questionnaire = new QuestionnaireFactory().getQuestionnaire(category);
			}
		});

	}

	void showWithAnimation(View view) {
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		alphaAnimation.setDuration(500);
		animationSet.addAnimation(alphaAnimation);
		view.startAnimation(animationSet);
		view.setAnimation(animationSet);
	}

	void hideWithAnimation(final View view, final OnClickListener listener) {
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
		alphaAnimation.setDuration(500);
		alphaAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				listener.onClick(view);
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

		});
		animationSet.addAnimation(alphaAnimation);
		view.startAnimation(animationSet);
		view.setAnimation(animationSet);
	}

	void generateAndShowResult() {
		testedProduct = questionnaire.getResult();
		category.saveTestedResult(this, testedProduct);
		createFragmentAndshowResult(testedProduct);
	}

	private void createFragmentAndshowResult(final Product result) {

		fragmentResult = new QuestionnaireResultFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentResult).commit();
	}

	long prePressBackTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// �ػ���˼�
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isTesting()) {
				long currentTime = new Date().getTime();
				// ���ʱ��������2��, ������
				if ((currentTime - prePressBackTime) > 2 * 1000) {
					// ��ʾ��Ϣ
					Toast.makeText(this, "�ٰ�һ���˳��Ƽ�", Toast.LENGTH_SHORT).show();
					// ����ʱ��
					prePressBackTime = currentTime;
					// �ػ��¼�,���ٴ���
					return true;
				}
			}
		}

		return super.onKeyDown(keyCode, event);
	}

	private boolean isTesting() {
		return findViewById(R.id.questionLayout).getVisibility() == View.VISIBLE;
	}

}

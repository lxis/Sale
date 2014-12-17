package com.sage.sale.ui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;
import com.sage.sale.domain.services.categories.CategoryFactory;
import com.sage.sale.domain.services.categories.CategoryStorage;
import com.sage.sale.domain.services.products.ProductShowValue;
import com.sage.sale.domain.services.products.ProductShowValueGenerator;
import com.sage.sale.domain.services.products.ProductValue;
import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;
import com.sage.sale.domain.services.questionnaires.QuestionnaireFactory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionnaireActivity extends FragmentActivity {

	// 全部的业务内容都在这
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
				// findViewById(R.id.questionLayout).setVisibility(View.VISIBLE);
				// findViewById(R.id.resultLayout).setVisibility(View.GONE);
				// ImageView imageViewResult = ((ImageView)
				// findViewById(R.id.imageViewResult));
				// imageViewResult.setVisibility(View.INVISIBLE);
				// ((TextView) findViewById(R.id.textViewResult)).setText("");
				// showQuestion();这个再说
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

		// showResult(result);
	}

	OnClickListener getBackListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		};
	}

	private void buyProduct(final String url) {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}

	boolean isShowingResult = true;

	long prePressBackTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 截获后退键
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isTesting()) {
				long currentTime = new Date().getTime();
				// 如果时间间隔大于2秒, 不处理
				if ((currentTime - prePressBackTime) > 2 * 1000) {
					// 显示消息
					Toast.makeText(this, "再按一次退出推荐", Toast.LENGTH_SHORT).show();
					// 更新时间
					prePressBackTime = currentTime;
					// 截获事件,不再处理
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

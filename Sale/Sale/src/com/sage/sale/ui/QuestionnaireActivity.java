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
import com.sage.sale.domain.services.products.Match;
import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.questionnaires.IQuestionnaire;
import com.sage.sale.domain.services.questionnaires.Question;
import com.sage.sale.domain.services.questionnaires.QuestionnaireFactory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionnaireActivity extends Activity {

	// 全部的业务内容都在这
	IQuestionnaire questionnaire;
	Category category;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.questionnaire_activity);

		String categoryJson = getIntent().getStringExtra("Category");
		category = new Gson().fromJson(categoryJson, CategorySerializeHelper.class).getCategory();
		questionnaire = new QuestionnaireFactory().getQuestionnaire(category);

		Product testedProduct = category.getTestedResult(this);
		if (testedProduct == null)
			showQuestion();
		else
			showResult(testedProduct);
	}

	private void addAnswer(String answer, final int index) {
		TextView textView = getAnswerTextView();
		textView.setText(answer);
		textView.setOnClickListener(getMoveNextClickListener(index));
		((LinearLayout) findViewById(R.id.answerLayout)).addView(textView, getAnswerTextViewLayoutParam());
	}

	private TextView getAnswerTextView() {
		TextView textView = new TextView(this);
		textView.setTextSize(20);
		textView.setTextColor(this.getResources().getColor(R.color.button_text_color));
		textView.setGravity(Gravity.CENTER);
		textView.setBackgroundResource(R.drawable.button_press_style_selector);
		textView.setPadding(50, 50, 50, 50);
		return textView;
	}

	private LinearLayout.LayoutParams getAnswerTextViewLayoutParam() {
		LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(800, LayoutParams.WRAP_CONTENT);
		layoutParam.setMargins(0, 50, 0, 50);
		layoutParam.gravity = Gravity.CENTER;
		return layoutParam;
	}

	private void restart() {
		hideWithAnimation(findViewById(R.id.resultLayout), new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				questionnaire = new QuestionnaireFactory().getQuestionnaire(category);
				findViewById(R.id.questionLayout).setVisibility(View.VISIBLE);
				findViewById(R.id.resultLayout).setVisibility(View.GONE);
				ImageView imageViewResult = ((ImageView) findViewById(R.id.imageViewResult));
				imageViewResult.setVisibility(View.INVISIBLE);
				((TextView) findViewById(R.id.textViewResult)).setText("");
				showQuestion();
			}
		});

	}

	private void showQuestion() {
		Question question = questionnaire.getQuestion();
		String questionText = question.getQuestion();
		((TextView) findViewById(R.id.textViewQuestion)).setText(questionText);
		((LinearLayout) findViewById(R.id.answerLayout)).removeAllViews();
		ArrayList<String> answers = question.getAnswers();
		for (int i = 0; i < answers.size(); i++)
			addAnswer(answers.get(i), i);
		ProgressBar progressBarProgress = (ProgressBar) findViewById(R.id.progressBarProgress);
		progressBarProgress.setMax(100);
		progressBarProgress.setProgress((int) (questionnaire.getProgress() * 100));
		showWithAnimation(findViewById(R.id.linearLayoutQuestionContent));

	}

	private void setAnswer(final int index) {
		questionnaire.setAnswer(index);
		hideWithAnimation(findViewById(R.id.linearLayoutQuestionContent), new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (questionnaire.getQuestion() == null)
					generateAndShowResult();
				else
					showQuestion();
			}
		});

	}

	private void showWithAnimation(View view) {
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		alphaAnimation.setDuration(500);
		animationSet.addAnimation(alphaAnimation);
		view.startAnimation(animationSet);
		view.setAnimation(animationSet);
	}

	private void hideWithAnimation(final View view, final OnClickListener listener) {
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

	private void generateAndShowResult() {
		final Product result = questionnaire.getResult();
		showResult(result);
		category.saveTestedResult(this, result);
	}

	private void showResult(final Product result) {
		findViewById(R.id.questionLayout).setVisibility(View.GONE);
		View resultLayout = findViewById(R.id.resultLayout);
		resultLayout.setVisibility(View.VISIBLE);
		findViewById(R.id.questionLayout).setVisibility(View.GONE);
		resultLayout.setVisibility(View.VISIBLE);

		final ImageView imageViewResult = ((ImageView) findViewById(R.id.imageViewResult));
		int imageResourceId = result.getImageResourceId();
		if (imageResourceId > 0) {
			imageViewResult.setImageResource(imageResourceId);
		} else {
			new AsyncTask<String, Integer, Drawable>() {

				@Override
				protected Drawable doInBackground(String... params) {
					URL thumb_u = null;
					try {
						thumb_u = new URL(result.getImageUrl());
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					Drawable thumb_d = null;
					try {
						thumb_d = Drawable.createFromStream(thumb_u.openStream(), "src");
					} catch (IOException e) {
						e.printStackTrace();
					}

					return thumb_d;
				}

				@Override
				protected void onPostExecute(Drawable resultPic) {
					imageViewResult.setImageDrawable(resultPic);
					imageViewResult.setVisibility(View.VISIBLE);
					showWithAnimation(imageViewResult);

					// showWithAnimation(textViewResult);

				}
			}.execute("");

		}
		findViewById(R.id.textViewBuy).setOnClickListener(getBuyProductListener(result.getUrl()));
		findViewById(R.id.textViewRestart).setOnClickListener(getRestartListener());
		findViewById(R.id.textViewBack).setOnClickListener(getBackListener());
		TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

		((TextView) findViewById(R.id.textViewEvaluation)).setText(Html.fromHtml(result.getEvaluation()));
		LinearLayout listViewMatches = (LinearLayout) findViewById(R.id.listViewMatches);
		listViewMatches.removeAllViews();
		for (Match match : result.getMatches()) {
			View matchView = createPercentMatchView(match);
			listViewMatches.addView(matchView);
		}

		textViewResult.setText(result.getName());
		showWithAnimation(resultLayout);
	}

	private OnClickListener getBackListener() {
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

	OnClickListener getRestartListener() {
		return new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				restart();
			}
		};
	}

	OnClickListener getBuyProductListener(final String url) {
		return new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				buyProduct(url);
			}
		};
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

	private View createPercentMatchView(Match item) {
		View view = LayoutInflater.from(this).inflate(R.layout.questionnaire_match_listitem, null);

		TextView textViewCategory = (TextView) view.findViewById(R.id.textViewMatchText);
		textViewCategory.setText(item.getText());
		ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBarMatch);

		progressBar.setMax(10);
		int score = item.getScore();
		if (score != 0)
			progressBar.setProgress(score);
		else
			progressBar.setProgress(10);
		return view;
	}

}

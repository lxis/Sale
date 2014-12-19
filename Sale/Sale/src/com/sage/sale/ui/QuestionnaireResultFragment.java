package com.sage.sale.ui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.sage.sale.R;
import com.sage.sale.domain.services.products.Product;
import com.sage.sale.domain.services.products.ProductShowValue;
import com.sage.sale.domain.services.products.ProductShowValueGenerator;

import android.support.v4.app.Fragment;
import android.text.Html;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class QuestionnaireResultFragment extends Fragment {

	QuestionnaireActivity activity;
	LayoutInflater inflater;
	View fragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		fragment = inflater.inflate(R.layout.questionnaire_result_control, container, false);
		addProductView(fragment);
		activity = (QuestionnaireActivity) getActivity();
		showResult();
		return fragment;

	}

	private void showResult() {
		final Product result = activity.testedProduct;
		((ScrollView) fragment.findViewById(R.id.scrollViewResult)).scrollTo(0, 0);
		(fragment.findViewById(R.id.linearProduct)).setVisibility(View.GONE);
		fragment.findViewById(R.id.linearResult).setVisibility(View.VISIBLE);
		((TextView) fragment.findViewById(R.id.textViewBuy)).setText("产品详情");
		isShowingResult = true;
		View resultLayout = fragment.findViewById(R.id.resultLayout);
		resultLayout.setVisibility(View.VISIBLE);

		final ImageView imageViewResult = ((ImageView) fragment.findViewById(R.id.imageViewResult));
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

				// 这个地方是真不优雅!
				int layoutWidth = ((LinearLayout) fragment.findViewById(R.id.linearResultContent)).getMeasuredWidth();
				LayoutParams picLayoutParams = imageViewResult.getLayoutParams();
				picLayoutParams.width = layoutWidth;
				picLayoutParams.height = layoutWidth;
				imageViewResult.setLayoutParams(picLayoutParams);

				imageViewResult.setVisibility(View.VISIBLE);
				activity.showWithAnimation(imageViewResult);
			}
		}.execute("");

		fragment.findViewById(R.id.textViewBuy).setOnClickListener(getBuyProductListener(result.getUrl()));
		fragment.findViewById(R.id.textViewRestart).setOnClickListener(getRestartListener());
		fragment.findViewById(R.id.textViewBack).setOnClickListener(getBackListener());
		TextView textViewResult = (TextView) fragment.findViewById(R.id.textViewResult);
		TextView textViewEvaluation = (TextView) fragment.findViewById(R.id.textViewEvaluation);
		textViewEvaluation.setText(Html.fromHtml(result.getEvaluation()));

		LinearLayout listViewMatches = (LinearLayout) fragment.findViewById(R.id.listViewMatches);
		listViewMatches.removeAllViews();
		ArrayList<ProductShowValue> productShowValues = new ProductShowValueGenerator().getProductShowValue(result.getMatches());
		for (ProductShowValue match : productShowValues) {
			View matchView = createPercentMatchView(match);
			listViewMatches.addView(matchView);
		}

		textViewResult.setText(result.getName());

		double resultTotalPercent = new ProductShowValueGenerator().getProductTotalShowValue(result);

		LinearLayout linearTotalStars = (LinearLayout) fragment.findViewById(R.id.linearTotalStars);
		LinearLayout linearTotalStarsEmpty = (LinearLayout) fragment.findViewById(R.id.linearTotalStarsEmpty);

		LayoutParams params = linearTotalStars.getLayoutParams();
		params.width = (int) (((double) linearTotalStarsEmpty.getLayoutParams().width) * ((double) resultTotalPercent));
		linearTotalStars.setLayoutParams(params);

		((TextView) fragment.findViewById(R.id.textViewTotalValue)).setText(new ProductShowValueGenerator().getProductTatalShowValueText(result));

		
		WebView webViewProduct = (WebView) fragment.findViewById(R.id.webViewProduct);
		String url = result.getUrl();
		webViewProduct.loadUrl(url);

		activity.showWithAnimation(resultLayout);
	}

	private void addProductView(View fragment) {
		View productView = inflater.inflate(R.layout.product_view, null);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		((LinearLayout) fragment.findViewById(R.id.linearProduct)).addView(productView, params);
	}

	private View createPercentMatchView(ProductShowValue item) {
		View view = inflater.inflate(R.layout.questionnaire_match_listitem, null);

		TextView textViewCategory = (TextView) view.findViewById(R.id.textViewMatchText);
		textViewCategory.setText(item.getName());
		((TextView) view.findViewById(R.id.textViewMatchDescrption)).setText(item.getText());
		LinearLayout linearStars = (LinearLayout) view.findViewById(R.id.linearStars);
		LayoutParams params = linearStars.getLayoutParams();
		params.width = (int) (((double) params.width) * ((double) item.getValue()));
		linearStars.setLayoutParams(params);
		return view;
	}

	OnClickListener getBuyProductListener(final String url) {
		return new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (isShowingResult)
					showProduct();
				else
					showBackResult();

			}

			private void showBackResult() {
				(fragment.findViewById(R.id.linearProduct)).setVisibility(View.GONE);
				fragment.findViewById(R.id.linearResult).setVisibility(View.VISIBLE);
				((TextView) fragment.findViewById(R.id.textViewBuy)).setText("产品详情");
				isShowingResult = true;
			}

			private void showProduct() {
				(fragment.findViewById(R.id.linearProduct)).setVisibility(View.VISIBLE);
				View linearResult = fragment.findViewById(R.id.linearResult);
				linearResult.setVisibility(View.GONE);
				((TextView) fragment.findViewById(R.id.textViewBuy)).setText("评测结果");
				isShowingResult = false;
			}
		};
	}

	OnClickListener getRestartListener() {
		return new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				activity.restart();
			}
		};
	}

	boolean isShowingResult = true;

	private OnClickListener getBackListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				activity.finish();
			}
		};
	}

}

package com.sage.sale.ui;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sage.sale.R;
import com.sage.sale.domain.services.products.Match;

public class MatchAdapter  extends SimpleAdapter<Match> {

	public MatchAdapter(ArrayList<Match> data, Context context, int layoutId) {
		super(data, context, layoutId);
	}

	@Override
	protected View createView(int layoutId, Match item) {
		View view = super.createView(layoutId, item);		

		TextView textViewCategory = (TextView) view.findViewById(R.id.textViewMatchText);
		textViewCategory.setText(item.getText());
		ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progressBarMatch);
		
		View  textViewMatchChecked =(View)view.findViewById(R.id.textViewMatchChecked);
		
		progressBar.setMax(10);
		int score = item.getScore();
		if(score!=0)
		{
			progressBar.setProgress(score);
			textViewMatchChecked.setVisibility(View.GONE);
		}
		else
		{
			progressBar.setVisibility(View.GONE);			
		}
		return view;
	}
}
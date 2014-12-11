package com.sage.sale.ui;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sage.sale.R;
import com.sage.sale.domain.services.products.Match;

public class MatchCheckedAdapter extends SimpleAdapter<Match> {

	public MatchCheckedAdapter(ArrayList<Match> data, Context context, int layoutId) {
		super(data, context, layoutId);
	}

	@Override
	protected View createView(int layoutId, Match item) {
		View view = super.createView(layoutId, item);		

		TextView textViewCategory = (TextView) view.findViewById(R.id.textViewCheckedMatchText);
		textViewCategory.setText(item.getText());
		return view;
	}
}
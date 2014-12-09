package com.sage.sale.ui;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.sage.sale.R;
import com.sage.sale.domain.services.categories.Category;
import com.sage.sale.domain.services.categories.beauty.*;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryAdapter extends SimpleAdapter<Category> {

	public CategoryAdapter(ArrayList<Category> data, Context context, int layoutId) {
		super(data, context, layoutId);
	}

	@Override
	protected View createView(int layoutId, Category item) {
		View view = super.createView(layoutId, item);

		AbsListView.LayoutParams param = new AbsListView.LayoutParams(500, 500);// Magic
																				// Number
		view.setLayoutParams(param);

		view.setOnClickListener(getClickListener(item));
		TextView textViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
		textViewCategory.setText(item.getName());
		
		ImageView imageViewCategories = (ImageView) view.findViewById(R.id.imageViewCategories);
		imageViewCategories.setImageResource(item.getImageId());
		
		return view;
	}

	private OnClickListener getClickListener(final Category item) {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!((item instanceof MianMo)||(item instanceof HuaZhuangShui))) {
					Toast.makeText(context, "¿ª·¢ÖÐ", 3000).show();
					return;
				}
				Intent intent = new Intent(context, QuestionnaireActivity.class);
				String itemJson = new Gson().toJson(new CategorySerializeHelper(item));
				intent.putExtra("Category", itemJson);
				context.startActivity(intent);
			}
		};
	}
}

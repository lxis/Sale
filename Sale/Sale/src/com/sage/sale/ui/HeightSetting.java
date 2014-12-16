package com.sage.sale.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
public class HeightSetting {
	public static int getWidth(View view) {
		int width = view.getMeasuredWidth();
		return width;
	}
	
	public static void setHeight(View view,int height)
	{
		LayoutParams layoutParams = view.getLayoutParams();
		layoutParams.height = height;
		view.setLayoutParams(layoutParams);
	}
}

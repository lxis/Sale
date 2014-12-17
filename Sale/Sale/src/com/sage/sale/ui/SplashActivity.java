package com.sage.sale.ui;

import com.sage.sale.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class SplashActivity extends FragmentActivity {

	boolean isEntered = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cover);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (!isEntered) {
					enterMainPage();
				}
			}
		}, 5000);

		findViewById(R.id.cover).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				isEntered = true;
				enterMainPage();
			}
		});
	}

	private void enterMainPage() {
		SplashActivity.this.startActivity(new Intent(SplashActivity.this, CategorySelectorActivity.class));
		SplashActivity.this.finish();
	}

}

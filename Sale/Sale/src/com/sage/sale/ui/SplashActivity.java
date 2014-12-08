package com.sage.sale.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SplashActivity.this.startActivity(new Intent(SplashActivity.this, CategorySelectorActivity.class));
		SplashActivity.this.finish();
	}
}

package com.sage.sale.ui;

import com.sage.sale.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ProductWebView extends WebView {

	public ProductWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		getSettings().setJavaScriptEnabled(true);
		setWebViewClient(new ProductWebViewClient());
		setWebChromeClient(new ProductWebChromeClient(context));
	}

	public ProductWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ProductWebView(Context context) {
		super(context);
		init(context);
	}

	public class ProductWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	public class ProductWebChromeClient extends android.webkit.WebChromeClient {
		Activity activity;

		public ProductWebChromeClient(Context context) {
			Log.i("bb", "1");
			activity = (Activity) context;
		}

		public void onProgressChanged(WebView view, int progress) {
			ProgressBar progressBar = (ProgressBar)activity.findViewById(R.id.progressBarProduct);
			if(progress!=100)
			{
				progressBar.setVisibility(View.VISIBLE);
				progressBar.setProgress(progress);
			}
			else
			{
				progressBar.setVisibility(View.GONE);			
			}
			Log.i("aa", String.valueOf(progress));
			super.onProgressChanged(view, progress);
		}
	}

}

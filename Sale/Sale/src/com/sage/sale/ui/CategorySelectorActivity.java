package com.sage.sale.ui;

import java.util.ArrayList;
import java.util.Date;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class CategorySelectorActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.categories_activity);
		InitDatas();
	}

	private void InitDatas() {
		
		GridView listViewProducts = (GridView)findViewById(R.id.listViewProducts);
		listViewProducts.setAdapter(new CategoryAdapter(new CategoryFactory().getAllCategory(),this,R.layout.category_listitem));
		
		
	}
	
	long prePressBackTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 截获后退键
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long currentTime = new Date().getTime();
			// 如果时间间隔大于2秒, 不处理
			if ((currentTime - prePressBackTime) > 2 * 1000) {
				// 显示消息
				Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
				// 更新时间
				prePressBackTime = currentTime;
				// 截获事件,不再处理
				return true;
			}
		}

		return super.onKeyDown(keyCode, event);
	}
}

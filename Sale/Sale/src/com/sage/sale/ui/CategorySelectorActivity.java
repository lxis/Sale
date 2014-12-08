package com.sage.sale.ui;

import java.util.ArrayList;
import java.util.Date;

import com.sage.sale.R;
import com.sage.sale.domain.services.categories.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
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
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(new Phone());
		categories.add(new LapTop());
		categories.add(new Tablet());
		categories.add(new TV());
		categories.add(new PC());
		ListView listViewProducts = (ListView)findViewById(R.id.listViewProducts);
		listViewProducts.setAdapter(new CategoryAdapter(categories,this,R.layout.category_listitem));
		
		
	}
	
	long prePressBackTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// �ػ���˼�
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long currentTime = new Date().getTime();
			// ���ʱ��������2��, ������
			if ((currentTime - prePressBackTime) > 2 * 1000) {
				// ��ʾ��Ϣ
				Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
				// ����ʱ��
				prePressBackTime = currentTime;
				// �ػ��¼�,���ٴ���
				return true;
			}
		}

		return super.onKeyDown(keyCode, event);
	}
}

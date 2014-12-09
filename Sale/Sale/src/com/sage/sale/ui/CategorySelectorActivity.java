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

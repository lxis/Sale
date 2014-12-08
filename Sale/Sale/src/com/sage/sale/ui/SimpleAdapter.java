package com.sage.sale.ui;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SimpleAdapter<T>  extends BaseAdapter {
	protected ArrayList<T> data;
	protected Context context;
	protected int layoutId;

	public SimpleAdapter(ArrayList<T> data, Context context, int layoutId) {
		this.data = data;
		this.context = context;
		this.layoutId = layoutId;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (data.get(position) == null)
			return null;
		if (convertView == null)		
			convertView = createView(layoutId,data.get(position));
		return convertView;
	}
	
	protected View createView(int layoutId,T item)
	{
		return LayoutInflater.from(context).inflate(layoutId, null);
	}
}
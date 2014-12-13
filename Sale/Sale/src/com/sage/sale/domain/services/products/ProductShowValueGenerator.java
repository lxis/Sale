package com.sage.sale.domain.services.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.internal.Primitives;

import android.util.Log;

public class ProductShowValueGenerator {
	@SuppressWarnings("unchecked")
	public ArrayList<ProductShowValue> getProductShowValue(ArrayList<ProductValue> productValues)
	{
		ArrayList<ProductShowValue> productShowValues = new ArrayList<ProductShowValue>();		
		Collections.sort(productValues, new SortByValue());
		if(productValues.size()==0)
			return new ArrayList<ProductShowValue>();
		ProductValue firstProductValue = productValues.get(0);				
		double mutipy = (double)1/(double)(firstProductValue.getValue()); 
		for(ProductValue productValue:productValues)
		{
			if(productValue.getValue()!=0)
			{
				ProductShowValue productShowValue = new ProductShowValue(productValue.getName(),productValue.getValue()*mutipy,productValue.getText());
				//≤Óæ‡»ıªØ
				productShowValue.setValue(((double)1 -((double)1-productShowValue.getValue())/2));
				
				productShowValues.add(productShowValue);
				Log.i("", productValue.getName()+":"+productValue.getValue());
			}
		}
		return productShowValues;
	}
	
	class SortByValue implements Comparator {
		 public int compare(Object o1, Object o2) {
			 ProductValue s1 = (ProductValue) o1;
			 ProductValue s2 = (ProductValue) o2;
			 return s2.getValue() - s1.getValue();
		 }
	}
}

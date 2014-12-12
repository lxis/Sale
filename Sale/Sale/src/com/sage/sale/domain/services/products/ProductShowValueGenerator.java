package com.sage.sale.domain.services.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.util.Log;

public class ProductShowValueGenerator {
	@SuppressWarnings("unchecked")
	public ArrayList<ProductShowValue> getProductShowValue(ArrayList<ProductValue> productValues)
	{
		ArrayList<ProductShowValue> productShowValues = new ArrayList<ProductShowValue>();		
		Collections.sort(productValues, new SortByValue());
		double mutipy = (double)1/(double)(productValues.get(0).getValue()); 
		for(ProductValue productValue:productValues)
		{
			if(productValue.getValue()!=0)
			{
				ProductShowValue productShowValue = new ProductShowValue(productValue.getText(),productValue.getValue()*mutipy);
				productShowValues.add(productShowValue);
				Log.i("", productValue.getText()+":"+productValue.getValue());
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

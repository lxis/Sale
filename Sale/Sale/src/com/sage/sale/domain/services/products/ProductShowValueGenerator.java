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
		if(productValues.size()==0)
			return new ArrayList<ProductShowValue>();
		ProductValue firstProductValue = productValues.get(0);				
		double mutipy = (double)1/(double)(firstProductValue.getValue()); 
		for(ProductValue productValue:productValues)
		{
			if(productValue.getValue()!=0)
			{
				ProductShowValue productShowValue = new ProductShowValue(productValue.getName(),productValue.getValue()*mutipy,productValue.getText());
				//�������
				productShowValue.setValue(((double)1 -((double)1-productShowValue.getValue())/2));
				
				productShowValues.add(productShowValue);
				Log.i("", productValue.getName()+":"+productValue.getValue());
			}
		}
		return productShowValues;
	}
	
	public double getProductTotalShowValue(Product product)
	{
		double resultPercent = ((double) product.getValue() / (double) product
				.getPrice());
		double resultShowPercent = resultPercent *0.4+0.2;
		return resultShowPercent;
	}
	
	public String getProductTatalShowValueText(Product product)
	{
		double resultPercent = getProductTotalShowValue(product);
		if(resultPercent>=0.9)
		{
			return "�˲�Ʒ������Ϊ����";
		}
		else if(resultPercent>=0.8)
		{
			return "�˲�Ʒ�����ǳ�����";
		}
		else if(resultPercent>=0.7)
		{
			return "�˲�Ʒ�����ܺ���";
		}
		else if(resultPercent>=0.6)
		{
			return "�˲�Ʒ�����ȽϺ���";
		}
		else
		{
			return "û�ҵ����ʵĲ�Ʒ";
		}		
	}
	
	class SortByValue implements Comparator {
		 public int compare(Object o1, Object o2) {
			 ProductValue s1 = (ProductValue) o1;
			 ProductValue s2 = (ProductValue) o2;
			 return s2.getValue() - s1.getValue();
		 }
	}
}

package com.sage.sale.domain.services.products.beauty;

import java.util.ArrayList;

import com.sage.sale.domain.services.products.Product;

public abstract class BaseProductRepository {
	protected ArrayList<Product> products = new ArrayList<Product>();
	
	public BaseProductRepository()
	{
		generateRepository();
	}
	
	protected abstract void generateRepository() ;

	public ArrayList<Product> getProducts()
	{
		return products;
	}
	
	public Product getProduct(int id)
	{
		for(int i = 0 ;i<products.size();i++)		
			if(products.get(i).getId() == id)
				return products.get(i);
		throw new RuntimeException("找不到这个产品");				
	}
}

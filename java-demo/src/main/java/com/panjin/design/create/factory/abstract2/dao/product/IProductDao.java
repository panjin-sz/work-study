package com.panjin.design.create.factory.abstract2.dao.product;

import com.panjin.design.create.factory.abstract2.bean.Product;

public interface IProductDao {
	
	void addProduct(Product product);
	
	void removeProduct(Product product);
	
	Product getProduct(String productname);

}

package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.entities.Product;


public interface ProductDao {
	public void insertProduct(Product p);
	public void updateProduct(Product p);
	public void deleteProduct(int pid);
	public List<Product> retirveAll();
	public Product retriveProductById(int pid);

}

package com.mphasis.training.daos;

import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;

public interface ProductDao {
	
	public void insertProduct(Product p)throws BuisnessException;
	public void updateProduct(int pid, int price,int qty)throws BuisnessException;
	public void deleteProduct(int pid)throws BuisnessException;
	public List<Product> getAll()throws BuisnessException;
	public Product getProductById(int pid)throws BuisnessException;
	

}

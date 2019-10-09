package com.mphasis.training.services;

import java.util.List;

import com.mphasis.training.entities.Product;
import com.mphasis.training.exceptions.BuisnessException;

public interface ProductService {
	public void addProduct(Product p) throws BuisnessException;
	public void updateProduct(Product p)throws BuisnessException;
	public void removeProduct(int pid)throws BuisnessException;
	public List<Product> getAll()throws BuisnessException;
	public Product getProductById(int pid)throws BuisnessException;
}

package com.mphasis.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.entities.Product;
import com.mphasis.training.exceptions.BuisnessException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	
	public void addProduct(Product p) throws BuisnessException {
		//if((p.getPid()>1) && (p.getPid()<300)) {
			if(p.getPname().matches("[A-Za-z]{3,20}")) {
				if((p.getQty()>1)&&(p.getQty()<50)) {
					if(p.getPcost()>10) {
						
							productDao.insertProduct(p);
						
					}else {
					throw new BuisnessException("cost should be greater than 10");
					}
				}else {
				throw new BuisnessException("qty between 1 to 50");
				}
			}else{
			throw new BuisnessException("name accepts only alphabets");
		}
//		}else {
//		throw new BuisnessException("id range is 1 to 300");
//		}
	}

	public void updateProduct(Product p) throws BuisnessException{
		//if((p.getPid()>1) && (p.getPid()<300)) {
			if(p.getPcost()>10) {
				if(p.getQty()>1 && p.getQty()<50) {
					productDao.updateProduct(p);
				}else {
					throw new BuisnessException("qty should be with in 1 to 50");
				}
			}else {
			throw new BuisnessException("Price should be greater thean 10");
			}
		/*
		 * }else { throw new BuisnessException("Id should be with in 1 to 300"); }
		 */

	}

	public void removeProduct(int pid)throws BuisnessException {
		if(pid>0)
		productDao.deleteProduct(pid);
		else
			throw new BuisnessException("enter valid pid");
	}

	public List<Product> getAll()throws BuisnessException {
		List<Product> products=productDao.retirveAll();
		if(products.isEmpty()) {
			throw new BuisnessException("No products available");
		}
		return products;
	}

	public Product getProductById(int pid)throws BuisnessException {
		// TODO Auto-generated method stub
		return productDao.retriveProductById(pid);
	}

}

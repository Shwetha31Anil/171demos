package com.mphasis.training.services;

import java.util.List;

import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.daos.ProductDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao=null;
    public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}

	@Override
	public void addProduct(Product p) throws BuisnessException {
	if((p.getPid()>1) && (p.getPid()<300)) {
		if(p.getPname().matches("[A-Za-z]{3,20}")) {
			if((p.getQty()>1)&&(p.getQty()<50)) {
				if(p.getCost()>10) {
					if(p.getBrand().matches("[A-Za-z]{4,15}")) {
						productDao.insertProduct(p);
					}else {
					throw new BuisnessException("brand accepts only alphabets");
					}
				}else {
				throw new BuisnessException("cost should be greater than 10");
				}
			}else {
			throw new BuisnessException("qty between 1 to 50");
			}
		}else{
		throw new BuisnessException("name accepts only alphabets");
	}
	}else {
	throw new BuisnessException("id range is 1 to 300");
	}
				
	}

	@Override
	public void editProduct(int pid, int price, int qty) throws BuisnessException {
		if((pid>1) && (pid<300)) {
			if(price>10) {
				if(qty>1 && qty<50) {
					productDao.updateProduct(pid, price, qty);
				}else {
					throw new BuisnessException("qty should be with in 1 to 50");
				}
			}else {
			throw new BuisnessException("Price should be greater thean 10");
			}
		}else {
			throw new BuisnessException("Id should be with in 1 to 300");
		}
	}

	@Override
	public void removeProduct(int pid) throws BuisnessException {
		productDao.deleteProduct(pid);

	}

	@Override
	public List<Product> getAll() throws BuisnessException {
		
		return productDao.getAll();
	}

	@Override
	public Product getProductById(int pid) throws BuisnessException {
		Product p=productDao.getProductById(pid);
		if(p==null) {
			throw new BuisnessException("the requested product is not avalaible");
		}
		return p;
	}

}

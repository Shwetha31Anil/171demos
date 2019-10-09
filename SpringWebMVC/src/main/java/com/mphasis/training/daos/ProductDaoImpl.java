package com.mphasis.training.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Product;

@Repository
public class ProductDaoImpl  implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;
	

	public void insertProduct(Product p) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(p);
	session.getTransaction().commit();
	}


	public void updateProduct(Product p) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}


	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
	}


	public List<Product> retirveAll() {
		Session session=sessionFactory.openSession();
		List<Product> products=session
								.createCriteria(Product.class)
								.list();
		return products;
	}


	public Product retriveProductById(int pid) {
		Session session=sessionFactory.openSession();
		Product p=(Product)session.get(Product.class, pid);
		return p;
	}

}

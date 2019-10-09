package com.mphasis.training.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.MOrder;
import com.mphasis.training.hibernate.pojos.Product;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class RelationShipDemo {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		  Session session=sf.openSession(); Product product=new Product();
		  product.setPname("MI4 mobile"); product.setCost(56456); product.setQty(54);
		  Product product1=new Product(); product1.setPname("MI5 mobile");
		  product1.setCost(58456); product1.setQty(34);
		  
		  
		  List<Product> ps=new ArrayList<Product>(); ps.add(product1); ps.add(product);
		  
		  MOrder o1=new MOrder(); o1.setOrderId(123); o1.setPname("XYZ");
		  //o1.setProduct(ps); o1.getProduct().add(product1); //o1.setProduct(product);
		  
		  MOrder o2=new MOrder(); o2.setOrderId(124); o2.setPname("XYZ");
		  //o2.getProduct().add(product); //o2.setProduct(ps);
		  
		 // o2.getProduct().add(product); o2.getProduct().add(product1);
		  
		  //o2.setProduct(product);
		  product.setOrder(o1);
		  product1.setOrder(o2);
		  
		  session.beginTransaction(); session.save(product); session.save(product1);
		  session.persist(o1); session.persist(o2);
		  
		  session.save(o1); session.save(o2);
		  
		  session.getTransaction().commit(); session.close();
		 
	}

}

package com.mphasis.training.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.hibernate.pojos.MOrder;
import com.mphasis.training.hibernate.pojos.Product;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class RealtionShipRetrivalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		MOrder order=(MOrder)session.get(MOrder.class, 123);
		
		/*
		 * Criteria cr=session.createCriteria(Product.class);
		 * cr.add(Restrictions.eq("order", order)); List<Product> products=cr.list();
		 * 
		 * products.forEach((ps1)->System.out.println(ps1));
		 */
	
		System.out.println(order);
		session.close();
	}

}

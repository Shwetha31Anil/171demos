package com.mphasis.training.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mphasis.training.hibernate.pojos.Employee;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		Configuration con=new Configuration().configure()
								.addAnnotatedClass(Employee.class);
		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder()
				.applySettings(con.getProperties());
		
		sessionFactory=con.buildSessionFactory(builder.build());
		return sessionFactory;
	}

}

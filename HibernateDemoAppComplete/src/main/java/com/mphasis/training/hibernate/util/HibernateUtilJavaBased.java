package com.mphasis.training.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mphasis.training.hibernate.pojos.Bus;
import com.mphasis.training.hibernate.pojos.DemoTest;
import com.mphasis.training.hibernate.pojos.Department;
import com.mphasis.training.hibernate.pojos.Employee;
import com.mphasis.training.hibernate.pojos.Location;
import com.mphasis.training.hibernate.pojos.MEmployee;
import com.mphasis.training.hibernate.pojos.MOrder;
import com.mphasis.training.hibernate.pojos.Passenger;
import com.mphasis.training.hibernate.pojos.Person;
import com.mphasis.training.hibernate.pojos.Product;
import com.mphasis.training.hibernate.pojos.Student;

public class HibernateUtilJavaBased {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		Configuration con=new Configuration();
		Properties props=new Properties();
		props.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
		props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
		props.put(Environment.USER, "shwe");
		props.put(Environment.PASS, "shwe");
		props.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
		props.put(Environment.HBM2DDL_AUTO,"update");
		props.put(Environment.SHOW_SQL,"true");
		props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		props.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		con.setProperties(props);
		con.addAnnotatedClass(Employee.class);
	StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder()
				.applySettings(con.getProperties());
		
		sessionFactory=con.buildSessionFactory(builder.build());
		return sessionFactory;
	}

}

package com.mphasis.training.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		Configuration con=new Configuration().configure()
				.addAnnotatedClass(Employee.class);
				//.addAnnotatedClass(Department.class);
								/*.addAnnotatedClass(Person.class)
								.addAnnotatedClass(MEmployee.class)
								.addAnnotatedClass(Student.class);
*/		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder()
				.applySettings(con.getProperties());
		
		sessionFactory=con.buildSessionFactory(builder.build());
		return sessionFactory;
	}

}

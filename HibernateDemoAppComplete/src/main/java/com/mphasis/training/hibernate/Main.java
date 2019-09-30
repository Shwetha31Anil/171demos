package com.mphasis.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.Employee;
import com.mphasis.training.hibernate.util.HibernateUtil;
import com.mphasis.training.hibernate.util.HibernateUtilJavaBased;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory sessionFactory=HibernateUtilJavaBased.getSessionFactory();
Session session=sessionFactory.openSession();

	Employee e1=(Employee)session.get(Employee.class, 1);
	System.out.println(e1.getEmpid()+""+e1.getEname());

	session.close();
	
	Session session1=sessionFactory.openSession();
	Employee e2=(Employee)session1.get(Employee.class, 1);
	System.out.println(e2.getEmpid()+""+e2.getEname());
	session1.close();
	


	}

}

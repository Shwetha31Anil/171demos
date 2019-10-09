package com.mphasis.training.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.Bus;
import com.mphasis.training.hibernate.pojos.Passenger;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class BusApp1 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
		Bus b=(Bus)session.get(Bus.class, new String("B012"));
		  System.out.println(b.getBid()+" "+b.getBname()); 
		  List<Passenger> pas=b.getPassengers(); 
		  for(Passenger p:pas) {
		  System.out.println(p.getPid()+" "+p.getPname()); 
		  }
		 
		
		session.close();
		

	}

}

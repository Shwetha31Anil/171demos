package com.mphasis.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.Bus;
import com.mphasis.training.hibernate.pojos.Passenger;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class BusApp {

	public static void main(String[] args) {
		Passenger p1=new Passenger();
		p1.setPid(12);
		p1.setPname("Harish");
		p1.setAge(21);
		p1.setJourneyDate("7-10-19");
		
		Bus bus=new Bus();
		bus.setBid("B012");
		bus.setBname("Vajara");
		
		
		p1.setBus(bus);
		
		bus.getPassengers().add(p1);
		Passenger p2=new Passenger();
		p2.setPid(13);
		p2.setPname("Mukesh");
		p2.setAge(21);
		p2.setJourneyDate("7-10-19");
		p2.setBus(bus);
		bus.getPassengers().add(p2);
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s1=sf.openSession();
		s1.beginTransaction();
		s1.save(bus);
		s1.save(p1);
		s1.save(p2);
		s1.getTransaction().commit();
		s1.close();
		

	}

}

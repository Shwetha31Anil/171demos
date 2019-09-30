package com.mphasis.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.MEmployee;
import com.mphasis.training.hibernate.pojos.Person;
import com.mphasis.training.hibernate.pojos.Student;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class InheritenceDemo {

	public static void main(String[] args) {
	SessionFactory sf=	HibernateUtil.getSessionFactory();
	Session s1=sf.openSession();
	s1.beginTransaction();
	Person p=new Person();
	p.setPid(32);
	p.setPname("Varshini");
	p.setPh_num(767687);
	MEmployee me=new MEmployee();
	me.setPid(23);
	me.setPname("Aruna");
	me.setPh_num(7678678);
	me.setSalary(64646);
	me.setManagername("Bhargav");
	me.setProject("Hibernate1");
	Student st=new Student();
	st.setPid(24);
	st.setPname("Manjuala");
	st.setPh_num(57623);
	st.setMarks(99);
	s1.save(p);
	s1.save(me);
	s1.save(st);
	s1.getTransaction().commit();
	s1.close();
	}

}

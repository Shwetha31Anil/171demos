package com.mphasis.training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mphasis.training.hibernate.pojos.MEmployee;
import com.mphasis.training.hibernate.pojos.Person;
import com.mphasis.training.hibernate.pojos.Student;
import com.mphasis.training.hibernate.util.HibernateUtil;
import com.mphasis.training.hibernate.util.HibernateUtilJavaBased;

public class InheritenceDemo {

	public static void main(String[] args) {
	HibernateUtilJavaBased.getSessionFactory();
	}

}

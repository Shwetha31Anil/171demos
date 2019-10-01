package com.mphasis.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mphasis.training.pojos.Employee;
import com.mphasis.training.pojos.Flight;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Resource resource=new ClassPathResource("application.xml"); BeanFactory
		 * beanFactory=new XmlBeanFactory(resource); Employee
		 * e1=beanFactory.getBean("employee",Employee.class);
		 * 
		 * System.out.println(e1);
		 */
		
		  AbstractApplicationContext context= new
		  ClassPathXmlApplicationContext("application.xml");
		 
		  Flight f1=(Flight)context.getBean("fid");
		  
		  context.close();
		
		/*
		 * Employee e1=context.getBean("employee",Employee.class); e1.setEname("Manoj");
		 * Employee e2=(Employee)context.getBean("employee"); e2.setEname("Manisha");
		 * 
		 * System.out.println(e1); System.out.println(e2);
		 */
    }
}

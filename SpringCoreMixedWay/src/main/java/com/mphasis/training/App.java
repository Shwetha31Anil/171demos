package com.mphasis.training;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.mphasis.training.pojos.Address;
import com.mphasis.training.pojos.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  	  AbstractApplicationContext context= new
  			  ClassPathXmlApplicationContext("application.xml");
  			 
  			  Address address=(Address)context.getBean("address");
  			  address.setCity("xyz");
  			  address.setStreet("mnb");
  			  address.setCountry("ght");
  			  address.setPincode(6557);
  			  
  			  Address address1=(Address)context.getBean("address");
  			  address1.setCity("bhg");
  			  address1.setStreet("mghnb");
  			  address1.setCountry("ght");
  			  address1.setPincode(6557);
  			  
  			  Employee e1=(Employee)context.getBean("employee");
  			  e1.setEmpId(123);
  			  e1.setEname("Shwetha");
  			  e1.setSalary("6556");
  			 // e1.setAddress(address);
  			  
  			  System.out.println(e1);
  			  context.close();
		/*
		 * Employee e1=context.getBean("employee",Employee.class); e1.setEname("Manoj");
		 * Employee e2=(Employee)context.getBean("employee"); e2.setEname("Manisha");
		 * 
		 * System.out.println(e1); System.out.println(e2);
		 */
    }
}

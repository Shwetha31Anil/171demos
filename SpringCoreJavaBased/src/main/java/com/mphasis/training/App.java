package com.mphasis.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mphasis.training.conf.AppConfig;
import com.mphasis.training.pojos.Address;
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
		
		  AbstractApplicationContext context= new
		  AnnotationConfigApplicationContext(AppConfig.class);
				  
				  
		  context.close();
		
		
    }
}

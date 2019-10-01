package com.mphasis.training;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;import com.mphasis.training.pojos.Answer;
import com.mphasis.training.pojos.Person;
import com.mphasis.training.pojos.Question;


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
		 
		  Question q1=context.getBean("q1",Question.class);
		  System.out.println("question id:"+q1.getQid());  
		    System.out.println("question name:"+q1.getQue());  
		    System.out.println("Answers....");
		   
		  List<Answer> as=q1.getAnswers();
		  as.forEach((a)->System.out.println(a));
		  
		  Map<Person, Answer> pans=q1.getPans();
		    Set<Entry<Person, Answer>> set=pans.entrySet();  
		    Iterator<Entry<Person, Answer>> itr=set.iterator();  
		    while(itr.hasNext()){  
		        Entry<Person, Answer> entry=itr.next();  
		        Person user=entry.getKey();  
		        Answer ans=entry.getValue();  
		        System.out.println("Answer Information:");  
		        System.out.println(ans);  
		        System.out.println("Posted By:");  
		        System.out.println(user);  
		    }  
		  context.close();
		
		/*
		 * Employee e1=context.getBean("employee",Employee.class); e1.setEname("Manoj");
		 * Employee e2=(Employee)context.getBean("employee"); e2.setEname("Manisha");
		 * 
		 * System.out.println(e1); System.out.println(e2);
		 */
    }
}

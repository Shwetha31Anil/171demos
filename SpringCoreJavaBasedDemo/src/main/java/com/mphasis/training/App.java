package com.mphasis.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.training.conf.AppConfig;
import com.mphasis.training.pojos.Laptop;
import com.mphasis.training.pojos.Processor;

public class App{
	public static void main(String args[]) {
		ApplicationContext context
		=new AnnotationConfigApplicationContext(AppConfig.class);
		Laptop lp=(Laptop)context.getBean("laptop");
		/*
		 * Processor processor=(Processor) context.getBean("mediaTeck");
		 * lp.setProcessor(processor);
		 */
		lp.getProcessor().Process();
		
	}
}
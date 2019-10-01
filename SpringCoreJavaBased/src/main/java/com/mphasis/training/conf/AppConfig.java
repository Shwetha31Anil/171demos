package com.mphasis.training.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.mphasis.training.pojos")
public class AppConfig {

	/*
	 * @Bean public Employee getEmployee(){ Employee e1=new Employee(); return e1; }
	 */
}

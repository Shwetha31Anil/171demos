package com.mphasis.training.pojos;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Flight implements InitializingBean, DisposableBean {

	public Flight() {
		System.out.println("Flight Called");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroyed");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("initialized");
		
	}
	
	/*
	 * public void init() { System.out.println("initalized"); }
	 * 
	 * public void destroy() { System.out.println("destroyes"); }
	 */
}

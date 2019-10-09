package com.mphasis.training.hibernate.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	private int jcode;
	private String jname;
	public int getJcode() {
		return jcode;
	}
	public void setJcode(int jcode) {
		this.jcode = jcode;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}

}




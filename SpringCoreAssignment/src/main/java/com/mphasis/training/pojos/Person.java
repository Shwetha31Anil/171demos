package com.mphasis.training.pojos;

public class Person {

	private int pid;
	private String pname;
	private long phNum;
	public Person() {
		
	}
	public Person(int pid, String pname, long phNum) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.phNum = phNum;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", phNum=" + phNum + "]";
	}
	
}

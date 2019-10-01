package com.mphasis.training.pojos;

public class Employee {
	
	private int empId;
	private String ename;
	private String salary;
	private Address address;
	public void init() {
		System.out.println("initalized");
	}
	
	public void destroy() {
		System.out.println("destroyes");
	}
	public Employee() {
		System.out.println("EMployee called");
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", salary=" + salary + ", address=" + address + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	

}

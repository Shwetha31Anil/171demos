package com.mphasis.training.hibernate.pojos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.Criteria;

@Entity
public class MEmployee {
	
	@Id
	private int empid;
	private FullName ename;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public FullName getEname() {
		return ename;
	}
	public void setEname(FullName ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	private double salary;
	private int bonus;
	@ManyToOne
	private Department department=new Department();
	@ManyToOne
	private Job job=new Job();
	/*
	 * select * from employee where deptid= (select deptid from department where
	 * dname='production');
	 */
	
	/*
	 * Criteria cr1=session.createCriteria(Department.class);
	 * cr.add(Restricts.eq("dname","production")); Department
	 * dept=cr.uniqueResult();
	 * 
	 * Criteria cr=session.CreateCriteria(Employee.class);
	 * cr.add(Restrictions.eq("department",dept)); cr.list();
	 */
	
	
	
	
}

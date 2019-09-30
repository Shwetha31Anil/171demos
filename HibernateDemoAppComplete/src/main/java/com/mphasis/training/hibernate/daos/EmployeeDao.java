package com.mphasis.training.hibernate.daos;

import java.util.List;

import com.mphasis.training.hibernate.pojos.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(int empid);
	public Employee getEmployeeById(int eid);
	public List<Employee> getAll();
	public Employee getEmployeeByEmail(String email);

}

package com.mphasis.training.hibernate;

import java.util.List;
import java.util.Scanner;

import com.mphasis.training.hibernate.daos.EmployeeDao;
import com.mphasis.training.hibernate.daos.EmployeeDaoImpl;
import com.mphasis.training.hibernate.pojos.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   EmployeeDao employeeDao=new EmployeeDaoImpl();
   Scanner sc=new Scanner(System.in);
   System.out.println("Welcome to employee app");
   do {
	   System.out.println("1.AddEmployee\n 2. Update Employee\n"
	   		+ "3.DeleteEMployee\n 4.GetEmployeeByID\n5.GetEmployeeByEmail\n"
	   		+ "6.GetAllEmployees\n 7.Exit");
	   int choice=sc.nextInt();
	   switch(choice) {
	   case 1:System.out.println("enter the employee details to add");
	          Employee e=new Employee();
	          System.out.println("entername,salary,doj,job,dept,bonus,email");
	          e.setEname(sc.next());
	          e.setSalary(sc.nextDouble());
	          e.setDoj(sc.next());
	          e.setJob(sc.next());
	          e.setDepartment(sc.next());
	          e.setBonus(sc.nextInt());
	          e.setEmail(sc.next());
	          employeeDao.addEmployee(e);
		   break;
	   case 2:System.out.println("enter the employee details to update");
       int id=sc.nextInt();
	   Employee e2=employeeDao.getEmployeeById(id);
	   System.out.println("enter salary, bonus to update");
	   e2.setSalary(sc.nextDouble());
	   e2.setBonus(sc.nextInt());
       employeeDao.updateEmployee(e2);
		   break;
	   case 3:System.out.println("enter the id to delete");
	   employeeDao.deleteEmployee(sc.nextInt());
		   break;
	   case 4:System.out.println("enter id to retrive");
	   Employee employee=employeeDao.getEmployeeById(sc.nextInt());
	   System.out.println(employee);
		   break;
	   case 5:System.out.println("enter email to retirve");
	   Employee e8=employeeDao.getEmployeeByEmail(sc.next());
	   System.out.println(e8);
		   break;
	   case 6: System.out.println("list of employees");   
		   List<Employee> employees=employeeDao.getAll();
	   			employees.forEach((e1)->
	   			System.out.println(e1));
		   break;
	   case 7: System.out.println("Thank you"); 
		   System.exit(0);
	   default: System.out.println("invalid");
	   }
   }while(true);
   
    	
    }
}

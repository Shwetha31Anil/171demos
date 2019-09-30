package com.mphasis.training.hibernate.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.hibernate.pojos.Employee;
import com.mphasis.training.hibernate.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory sessionFactory;
	public EmployeeDaoImpl() {
	sessionFactory= HibernateUtil.getSessionFactory();
	}

	public void addEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(e);
		session.getTransaction().commit();
		session.close();

	}

	public void deleteEmployee(int empid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee e=(Employee)session.get(Employee.class, empid);
		session.delete(e);
		session.getTransaction().commit();
		session.close();

	}

	public Employee getEmployeeById(int eid) {
		Session session=sessionFactory.openSession();
		Employee e=(Employee)session.get(Employee.class, eid);
		return e;
	}

	public List<Employee> getAll() {
		Session session=sessionFactory.openSession();
		List<Employee> employees=
				session.createCriteria(Employee.class).list();
		return employees;
	}

	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("email",email));
		Employee emp=(Employee) cr.uniqueResult();
		return emp;
	}

}

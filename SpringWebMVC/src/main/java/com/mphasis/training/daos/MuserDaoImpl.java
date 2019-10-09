package com.mphasis.training.daos;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Muser;

@Repository
public class MuserDaoImpl implements MuserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public Muser login(String username, String pass) {
		System.out.println("before login called ");
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Muser.class);
		Criterion uname=Restrictions.eq("username", username);
		Criterion password=Restrictions.eq("pass", pass);
		LogicalExpression andExpression =
				Restrictions.and(uname,password);
		cr.add(andExpression);
		Muser muser=(Muser) cr.uniqueResult();
		System.out.println("login called after");
		return muser;
	}

	public Muser getUserByUserName(String username) {
		// TODO Auto-generated method stub
		System.out.println("before getUserrBYusername called ");
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Muser.class);
		cr.add(Restrictions.eq("username", username));
		Muser user=(Muser) cr.uniqueResult();
		System.out.println("after getUserrBYusername called ");
		return user;
	}

	public void updatePassword(Muser user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public int registerUser(Muser user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int userId=(Integer)session.save(user);
		session.getTransaction().commit();
		session.close();
		return userId;
	}

}

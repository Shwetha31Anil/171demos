package com.mphasis.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.daos.MuserDao;
import com.mphasis.training.entities.Muser;
import com.mphasis.training.exceptions.BuisnessException;

@Service
public class MuserServiceImpl implements MuserService {
	
	@Autowired
	private MuserDao muserDao;

	public Muser login(String username, String pass)throws BuisnessException {
		// TODO Auto-generated method stub
		System.out.println("login called before service");
		Muser user=muserDao.login(username, pass);
		if(user==null) {
			throw new BuisnessException("invalid credentials");
		}
		System.out.println("login called after service");
		return user;
	}

	public Muser getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return muserDao.getUserByUserName(username);
	}

	public void updatePassword(Muser user) {
		// TODO Auto-generated method stub
		muserDao.updatePassword(user);
	}

	public int registerUser(Muser user) {
		// TODO Auto-generated method stub
		return muserDao.registerUser(user);
	}

}

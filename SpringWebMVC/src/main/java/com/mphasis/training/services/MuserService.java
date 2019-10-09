package com.mphasis.training.services;

import com.mphasis.training.entities.Muser;
import com.mphasis.training.exceptions.BuisnessException;

public interface MuserService {
	public Muser login(String username,String pass)throws BuisnessException;
	public Muser getUserByUserName(String username);
	public void updatePassword(Muser user);
	public int registerUser(Muser user);
}

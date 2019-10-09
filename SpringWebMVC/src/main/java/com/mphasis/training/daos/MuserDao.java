
package com.mphasis.training.daos;

import com.mphasis.training.entities.Muser;

public interface MuserDao {
	public Muser login(String username,String pass);
	//select * from Muser where username=? and password=?
	public Muser getUserByUserName(String username);
	public void updatePassword(Muser user);
	public int registerUser(Muser user);

}

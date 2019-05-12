package com.revature.services;

import com.reavture.daos.LoginDao;
import com.revature.beans.Credentials;
import com.revature.beans.User;

public class LoginService {
	LoginDao loginDao = new LoginDao();


	public int login(Credentials credentials) {
		// attempt to retrieve username/password from database
		User user = loginDao.getPasswordByUsername(credentials.getUsername());
		// compare them
		if (!user.getErsPassword().equals(credentials.getPassword())) {
			throw new HttpException(400);
		}
		return user.getErsUserID();
	}
}

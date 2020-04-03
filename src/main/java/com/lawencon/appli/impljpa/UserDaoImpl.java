package com.lawencon.appli.impljpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.appli.dao.UserDao;
import com.lawencon.appli.model.UserLog;

@Repository("user_repo_jpa")
public class UserDaoImpl implements UserDao{
	@Autowired
	UserRepo userRepo;

	@Override
	public boolean findByUsPs(String usname, String psword) throws Exception {
		UserLog userLog = null;
		try {
			userLog = userRepo.findByUsernameAndPassword(usname, psword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userLog !=null) {
			return true;
		} else {
			return false;
		}
	}

}
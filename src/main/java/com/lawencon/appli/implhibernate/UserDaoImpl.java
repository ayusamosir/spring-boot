package com.lawencon.appli.implhibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.appli.dao.UserDao;
import com.lawencon.appli.model.UserLog;

@Repository("user_repo_hiber")
public class UserDaoImpl extends ParkiranEm implements UserDao {
	
	@Override
	public boolean findByUsPs(String usname, String psword) throws Exception {
		Query q = em.createNativeQuery(" from UserLog where username = :idParam1 and password =: idParam2");
		q.setParameter("iParam1", usname);
		q.setParameter("idParam2", psword);
		q.getResultList();
		List<UserLog> userLog = new ArrayList<>();
		if (userLog.isEmpty()) {
			System.out.println("Invali User!");
			return false;
		} 
		return true;
	}

}

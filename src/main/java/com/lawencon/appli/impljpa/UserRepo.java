package com.lawencon.appli.impljpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.appli.model.UserLog;

public interface UserRepo extends JpaRepository<UserLog, Long> {
	
	UserLog findByUsernameAndPassword(String usname, String psword);
}

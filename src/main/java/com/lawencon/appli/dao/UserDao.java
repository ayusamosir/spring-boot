package com.lawencon.appli.dao;

public interface UserDao {
	abstract boolean findByUsPs(String usname, String psword)throws Exception;
}

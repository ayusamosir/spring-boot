package com.lawencon.appli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String username , password;

	public String getUsernm() {
		return username;
	}

	public void setUsernm(String username) {
		this.username = username;
	}

	public String getPasswrd() {
		return password;
	}

	public void setPasswrd(String password) {
		this.password = password;
	}
	

}

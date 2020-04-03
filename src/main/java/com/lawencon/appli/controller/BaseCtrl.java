package com.lawencon.appli.controller;

import java.util.Base64;

public abstract class BaseCtrl {
	public String[] authorUser(String author) {
		byte[] decodBytes = Base64.getDecoder().decode(author);
		String decodString = new String(decodBytes);
		String[] authorArr = decodString.split(":");
		return authorArr;
	}
}

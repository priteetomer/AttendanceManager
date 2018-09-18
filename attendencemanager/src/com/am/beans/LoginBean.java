package com.am.beans;

import com.am.dao.LoginDAO;

public class LoginBean {

	private String id;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLogin(){
		return new LoginDAO().checkLogin(id, password);
	}

	public String checkTeacherLogin() {
		return new LoginDAO().checkTeacherLogin(id, password);
	}
}

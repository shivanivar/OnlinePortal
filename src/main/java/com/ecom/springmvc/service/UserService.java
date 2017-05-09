package com.ecom.springmvc.service;

import javax.servlet.http.HttpSession;

import com.ecom.springmvc.model.User;

public interface UserService {

	public void addUser(User u);

	public void updateUser(User p);

	public boolean checkLogin(String userEmail, String userPassword,HttpSession httpSession);


}

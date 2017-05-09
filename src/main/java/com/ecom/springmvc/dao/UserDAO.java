package com.ecom.springmvc.dao;

import javax.servlet.http.HttpSession;

import com.ecom.springmvc.model.User;

public interface UserDAO {

	/*public List<User> listUser();*/

	public void addUser(User u);

	public void updateUser(User u);

	public boolean checkLogin(String userEmail, String userPassword,HttpSession httpSession);
}


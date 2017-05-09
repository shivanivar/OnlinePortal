package com.ecom.springmvc.service.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.springmvc.dao.UserDAO;
import com.ecom.springmvc.model.User;
import com.ecom.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDao.addUser(u);
		
	}


	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDao.updateUser(u);
		
	}


	@Override
	@Transactional
	public boolean checkLogin(String userEmail, String userPassword,HttpSession httpSession) {
		
		return userDao.checkLogin(userEmail, userPassword,httpSession);
	}

}

package com.ecom.springmvc.dao.daoImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.springmvc.dao.UserDAO;
import com.ecom.springmvc.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<User> listUser() { Session session =
	 * this.sessionFactory.getCurrentSession(); List<User> userList =
	 * session.createQuery("FROM User").list(); session.close(); for (User u :
	 * userList) { logger.info("User List::" + u);
	 * 
	 * } return userList; }
	 */

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		User newUser = new User();
		newUser.setName(u.getName());
		newUser.setUser_email(u.getUser_email());
		newUser.setUser_address(u.getUser_address());
		newUser.setUser_phone(u.getUser_phone());
		newUser.setRole("User");
		newUser.setPassword(u.getPassword());
		session.persist(newUser);
		logger.info("User saved successfully, User Details=" + newUser);

	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User saved successfully, User Details=" + u);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkLogin(String userEmail, String userPassword, HttpSession httpSession) {
		Session session = this.sessionFactory.getCurrentSession();
		session.getSessionFactory().openSession();
		boolean userFound = false;
		String SQL_QUERY = " from User as u where u.user_email=? and u.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userEmail);
		query.setParameter(1, userPassword);
		List list = query.list();

		if (!list.isEmpty()) {

			httpSession.setAttribute("user", (User) list.get(0));
			userFound = true;
		}

		return userFound;
	}

}

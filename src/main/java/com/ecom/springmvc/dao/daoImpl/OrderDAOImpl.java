package com.ecom.springmvc.dao.daoImpl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.springmvc.dao.OrderDao;
import com.ecom.springmvc.model.Orders;

@Repository
public class OrderDAOImpl  implements OrderDao {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listOrder() {
		Session session =this.sessionFactory.getCurrentSession();
		List<Orders> ordersList = session.createQuery("FROM Orders").list();
		session.close();
		for (Orders p : ordersList) {
			logger.info("Orders List::" + p);

		}
		return ordersList;
	}

	@Override
	public int addOrder(Orders o) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("OrderDetails----------------------- "+o);
		session.persist(o);
		BigInteger result=(BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		int r=result.intValue();
		logger.info("----------------Order ID-----------");
		logger.info(result);
		logger.info("----------------------Order saved successfully, Order is----------------=" + o);
		return r;

	}

	@Override
	public void updateOrder(Orders o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
		logger.info("Orders saved successfully, Orders Details=" + o);

	}

	@Override
	public void deleteOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders p = (Orders) session.load(Orders.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Orders deleted successfully, orders details=" + p);
	}

	@Override
	public Orders getOrderById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders p = (Orders) session.load(Orders.class, new Integer(id));
		logger.info("Orders loaded successfully, Orders details=" + p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrdersByUserId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Orders where user_id= "+id).list();
	}

}

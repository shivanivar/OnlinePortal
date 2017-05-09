package com.ecom.springmvc.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.springmvc.dao.BaseDao;
import com.ecom.springmvc.dao.OrderDetailsDao;
import com.ecom.springmvc.model.OrderDetails;


@Repository
public class OrderDetailsDAOImpl extends BaseDao implements OrderDetailsDao {
	
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<OrderDetails> listOrder() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<OrderDetails> order_detailsList = session.createQuery("FROM Order_Details").list();
		session.close();
		for (OrderDetails p : order_detailsList) {
			logger.info("Order_Details List::" + p);

		}
		return order_detailsList;
	}

	@Override
	public void addOrder_Details(OrderDetails o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Order Details  saved successfully, Order Details=" + o);
	}

	@Override
	public void updateOrder_Details(OrderDetails o) {
		Session session = getSessionFactory().openSession();
		session.update(o);
		logger.info("Order_Details saved successfully, Order_Details Details=" + o);
	}

	@Override
	public void deleteOrder_Details(int id) {
		Session session = getSessionFactory().openSession();
		OrderDetails p = (OrderDetails) session.load(OrderDetails.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Order_Details deleted successfully, order_details details=" + p);
	}

	@Override
	public OrderDetails getOrder_DetailsById(int id) {
		Session session = getSessionFactory().openSession();
		OrderDetails p = (OrderDetails) session.load(OrderDetails.class, new Integer(id));
		logger.info("Order_Details loaded successfully, Order_Details details="+p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> getOrderByOrderId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderDetails> order_detailsList = session.createQuery("FROM OrderDetails where order_id="+id).list();
		return order_detailsList;
	}

}

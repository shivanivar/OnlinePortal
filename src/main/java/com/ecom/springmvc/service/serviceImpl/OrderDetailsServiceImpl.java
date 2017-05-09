package com.ecom.springmvc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.springmvc.dao.OrderDetailsDao;
import com.ecom.springmvc.model.OrderDetails;
import com.ecom.springmvc.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsDao order_detailsDao;
	
	
	public void setOrder_detailsDao(OrderDetailsDao order_detailsDao) {
		this.order_detailsDao = order_detailsDao;
	}

	@Override
	@Transactional
	public List<OrderDetails> listOrder_Details() {
		return this.order_detailsDao.listOrder();
	}

	@Override
	@Transactional
	public void addOrder_Details(OrderDetails o) {
		this.order_detailsDao.addOrder_Details(o);
		
	}

	@Override
	@Transactional
	public void updateOrder_Details(OrderDetails o) {
		this.order_detailsDao.updateOrder_Details(o);
		
	}

	@Override
	@Transactional
	public void deleteOrder_Details(int id) {
	this.order_detailsDao.deleteOrder_Details(id);
		
	}

	@Override
	@Transactional
	public OrderDetails getOrder_DetailsById(int id) {
		return this.order_detailsDao.getOrder_DetailsById(id);
	}

	@Override
	@Transactional
	public List<OrderDetails> getOrderByOrderId(int id) {
		return this.order_detailsDao.getOrderByOrderId(id);
	}

}

package com.ecom.springmvc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.springmvc.dao.OrderDao;
import com.ecom.springmvc.model.Orders;
import com.ecom.springmvc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public List<Orders> listOrders() {
		return this.orderDao.listOrder();
	}

	@Override
	@Transactional
	public int addOrders(Orders o) {
		return this.orderDao.addOrder(o);

	}

	@Override
	@Transactional
	public void updateOrders(Orders o) {
		this.orderDao.updateOrder(o);

	}

	@Override
	@Transactional
	public void deleteOrders(int id) {
		this.orderDao.deleteOrder(id);

	}

	@Override
	@Transactional
	public Orders getOrdersById(int id) {
		return this.orderDao.getOrderById(id);
	}
	
	public int getOrderId()
	{
		return 1;
	}

	@Override
	@Transactional
	public List<Orders> getOrdersByUserId(int id) {
		
		return this.orderDao
				.getOrdersByUserId(id);
	}

}

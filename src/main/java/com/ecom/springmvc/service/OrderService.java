package com.ecom.springmvc.service;

import java.util.List;

import com.ecom.springmvc.model.Orders;

public interface OrderService {

	public List<Orders> listOrders();

	public int addOrders(Orders o);

	public void updateOrders(Orders o);

	public void deleteOrders(int id);

	public Orders getOrdersById(int id);
	
	public List<Orders> getOrdersByUserId(int id);
}

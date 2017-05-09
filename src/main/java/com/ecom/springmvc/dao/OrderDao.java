package com.ecom.springmvc.dao;

import java.util.List;

import com.ecom.springmvc.model.Orders;

public interface OrderDao {

	public List<Orders> listOrder();

	public int addOrder(Orders o);

	public void updateOrder(Orders o);

	public void deleteOrder(int id);

	public Orders getOrderById(int id);
	
	public List<Orders> getOrdersByUserId(int id);
}

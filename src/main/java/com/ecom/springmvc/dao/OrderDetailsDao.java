package com.ecom.springmvc.dao;

import java.util.List;

import com.ecom.springmvc.model.OrderDetails;

public interface OrderDetailsDao {

	public List<OrderDetails> listOrder();

	public void addOrder_Details(OrderDetails o);

	public void updateOrder_Details(OrderDetails o);

	public void deleteOrder_Details(int id);

	public OrderDetails getOrder_DetailsById(int id);
	
	public List<OrderDetails> getOrderByOrderId(int id);
}

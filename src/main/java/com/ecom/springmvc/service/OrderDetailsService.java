package com.ecom.springmvc.service;

import java.util.List;

import com.ecom.springmvc.model.OrderDetails;
import com.ecom.springmvc.model.Orders;

public interface OrderDetailsService {

	public List<OrderDetails> listOrder_Details();

	public void addOrder_Details(OrderDetails o);

	public void updateOrder_Details(OrderDetails o);

	public void deleteOrder_Details(int id);

	public OrderDetails getOrder_DetailsById(int id);

	public List<OrderDetails> getOrderByOrderId(int id);

	

}

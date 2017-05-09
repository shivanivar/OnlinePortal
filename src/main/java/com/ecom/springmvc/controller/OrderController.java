package com.ecom.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.springmvc.model.Item;
import com.ecom.springmvc.model.OrderDetails;
import com.ecom.springmvc.model.Orders;
import com.ecom.springmvc.model.User;
import com.ecom.springmvc.service.OrderDetailsService;
import com.ecom.springmvc.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private static final Logger logger = Logger.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailsService orderDetailsService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrder_detailsService(OrderDetailsService order_detailsService) {
		this.orderDetailsService = order_detailsService;
	}

	// For add and update orders both
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String addOrder(HttpSession session) {

		Orders o = new Orders();
		int amount = 0;
		List<Item> items = (List<Item>) session.getAttribute("cart");
		for (Item i : items) {
			amount = amount + (int) ((i.getQuantity()) * (i.getProduct().getPrice()));
			o.setAmount(amount);
		}
		
		items.forEach(i -> logger.info("------Name Of Product ---------" + i.getProduct().getName()));
		if (o.getId() == 0) {
			// new order, add it
			User u = (User) session.getAttribute("user");
			o.setUser_id(u);
			int orderId = this.orderService.addOrders(o);
			o.setId(orderId);
			session.setAttribute("orderModel", o);
			logger.info("-----------Order object---------- "+o);

		} 
		return "redirect:/orders/order_details/add";

	}

	@RequestMapping(value = "/orderhistory", method = RequestMethod.GET)
	public String listOrderHistory(Model model, HttpSession session) {
		model.addAttribute("orderHistory", new Orders());

		List<Orders> l1 = new ArrayList<Orders>();

		List<List<OrderDetails>> l2 = new ArrayList<List<OrderDetails>>();

		User u = (User) session.getAttribute("user");
		l1 = this.orderService.getOrdersByUserId(u.getId());
		for (int i = 0; i < l1.size(); i++) {
			l2.add(this.orderDetailsService.getOrderByOrderId(l1.get(i).getId()));

		}
		model.addAttribute("listOrders", l1);
		model.addAttribute("listOrder_details", l2);
		logger.info("-----------Fetched Order History---------- ");

		return "orderHistory";
	}

	@RequestMapping(value = "/order_details", method = RequestMethod.GET)
	public String listOrder_Details(Model model) {
		model.addAttribute("order_details", new OrderDetails());
		model.addAttribute("listOrders_Details", this.orderDetailsService);
		return "order_details";
	}

	// For add and update orders both
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/order_details/add")
	public String addorder_details(HttpSession session) {
		List<Item> items = (List<Item>) session.getAttribute("cart");
		Orders orderModel = (Orders) session.getAttribute("orderModel");
		// new product, add it
		items.forEach(i -> {
			OrderDetails o = new OrderDetails();
			o.setPrice(i.getProduct().getPrice());
			o.setProduct_code(i.getProduct());
			o.setQuanity(i.getQuantity());
			o.setOrder_id(orderModel);
			this.orderDetailsService.addOrder_Details(o);

		});
		logger.info("-----------Added order details---------- ");
		session.removeAttribute("cart");
		return "orderConf";

	}

}
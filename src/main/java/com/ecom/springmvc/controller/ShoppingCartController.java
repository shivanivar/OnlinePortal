package com.ecom.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.springmvc.model.Item;
import com.ecom.springmvc.service.ProductService;

@Controller
@RequestMapping(value = "/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private ProductService productservice;
		
	private static final Logger logger = Logger.getLogger(ShoppingCartController.class);
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String orderNow(@RequestParam("code") String s,ModelMap map,HttpSession session )
	{	
		/*if(session.getAttribute("user")== null)
		{
			
			return "buyProduct";
		}*/
		System.out.println("show the code"+s);
		String[] values = s.split(",");
		System.out.println("value in cart"+ s);
		for (int i = 0; i < values.length; i++) {
			int code=Integer.parseInt(values[i]);
		
		if(session.getAttribute("cart")==null)
		{
			List<Item> cart=new ArrayList<Item>();
			cart.add(new Item(productservice.getProductByCode(code), 1));
			session.setAttribute("cart", cart);
		}
		else
		{
			List<Item> cart=(List<Item>)session.getAttribute("cart");
			int index=isExisting(code, session);
			if(index==-1)
			{
				cart.add(new Item(productservice.getProductByCode(code),1));
			}
			else
			{
				int quantity=cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		}
		return "redirect:/products/buy";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cart",method=RequestMethod.POST)
	private String showCart(HttpSession session)
	{
		 List<Item> cart = (List<Item>) session.getAttribute("cart");
		 System.out.println(cart);
		 logger.info("------------Cart List---------"+cart);
		return "cart";
		
	}
	
	 @SuppressWarnings("unchecked")
	 private int isExisting(int code, HttpSession session) {

	  List<Item> cart = (List<Item>) session.getAttribute("cart");

	  for (int i = 0; i < cart.size(); i++)

	   if (cart.get(i).getProduct().getCode() == code)
	    return i;

	  return -1;
	 }

}

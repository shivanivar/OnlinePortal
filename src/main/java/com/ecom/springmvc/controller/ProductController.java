package com.ecom.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.springmvc.model.Product;
import com.ecom.springmvc.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	
	public void setProductService(ProductService ps) {
		this.productService = ps;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProduct());
		logger.info("-----------Listed All Products ---------- ");
		return "buyProduct";
	}

	
	@RequestMapping("/buy")
	public String buyProduct(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProduct());
		logger.info("-----------Buying Products ---------- ");
		return "buyProduct";
	}

}
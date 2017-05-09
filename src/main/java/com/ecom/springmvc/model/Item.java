package com.ecom.springmvc.model;

import org.springframework.stereotype.Component;

@Component 
public class Item {
	
	private Product product=new Product();
	
	private int quantity;
	
	

	public Item() {
		super();
	}
	

	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product p) {
		this.product = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}

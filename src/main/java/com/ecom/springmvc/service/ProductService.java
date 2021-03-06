package com.ecom.springmvc.service;

import java.util.List;

import com.ecom.springmvc.model.Product;

public interface ProductService {

	public List<Product> listProduct();

	public void addProduct(Product p);

	public void updateProduct(Product p);

	public void deleteProduct(int code);

	public Product getProductByCode(int code);
}

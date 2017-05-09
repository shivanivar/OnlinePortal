package com.ecom.springmvc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.springmvc.dao.ProductDao;
import com.ecom.springmvc.model.Product;
import com.ecom.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> listProduct() {
		return this.productDao.listProduct();
	}

	@Override
	@Transactional
	public void addProduct(Product p) {
		this.productDao.addProduct(p);

	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		this.productDao.updateProduct(p);

	}

	@Override
	@Transactional
	public void deleteProduct(int code) {
		this.productDao.deleteProduct(code);

	}

	@Override
	@Transactional
	public Product getProductByCode(int code) {
		return this.productDao.getProductByCode(code);
	}

}

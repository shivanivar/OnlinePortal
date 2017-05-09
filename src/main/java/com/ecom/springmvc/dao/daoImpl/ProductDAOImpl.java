package com.ecom.springmvc.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ecom.springmvc.dao.BaseDao;
import com.ecom.springmvc.dao.ProductDao;
import com.ecom.springmvc.model.Product;

@Repository
public class ProductDAOImpl extends BaseDao implements ProductDao {

	private static final Logger logger = Logger.getLogger(ProductDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProduct() {
		Session session = getSessionFactory().openSession();
		List<Product> productList = session.createQuery("FROM Product").list();
		session.close();
		for (Product p : productList) {
			logger.info("Product List::" + p);

		}
		return productList;
	}

	@Override
	public void addProduct(Product p) {
		Session session = getSessionFactory().openSession();
		session.persist(p);
		logger.info("User saved successfully, User Details=" + p);

	}

	@Override
	public void updateProduct(Product p) {
		Session session = getSessionFactory().openSession();
		session.update(p);
		logger.info("Product saved successfully, Product Details=" + p);

	}

	@Override
	public void deleteProduct(int code) {
		Session session = getSessionFactory().openSession();
		Product p = (Product) session.load(Product.class, new Integer(code));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Product deleted successfully, product details=" + p);

	}

	@Override
	public Product getProductByCode(int code) {
		Session session = getSessionFactory().openSession();
		Product p = (Product) session.load(Product.class, new Integer(code));
		logger.info("Product loaded successfully, Product details="+p);
		return p;
	}

}

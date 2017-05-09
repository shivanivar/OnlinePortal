package com.ecom.springmvc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BaseDao {

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-annotation.cfg.xml");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
}

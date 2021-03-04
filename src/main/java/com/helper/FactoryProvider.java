package com.helper;

import javax.persistence.EntityManagerFactory;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class FactoryProvider {
	public static org.hibernate.SessionFactory factory;

	public static org.hibernate.SessionFactory getFactory() {
		if (factory == null) {
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}

		return factory;
	}

	public void closeFactory() {
		if (factory.isOpen()) {
			factory.close();
		}
	}
}

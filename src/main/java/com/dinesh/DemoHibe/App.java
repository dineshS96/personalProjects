package com.dinesh.DemoHibe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Alien a = null ;
		//new Alien();
		//a.setAname("Bhavesh");
		//a.setColor("laal");
		//a.setId(110);

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		session.beginTransaction();

		a = (Alien) session.get(Alien.class, 110);
		System.out.println(a);
		/*
		 * a = (Alien) session.get(Alien.class, 106); System.out.println(a);
		 */
		//session.save(a);
		session.getTransaction().commit();

		// System.out.println(dinesh);
	}

}

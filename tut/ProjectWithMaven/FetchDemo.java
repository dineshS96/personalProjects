package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get,load example
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.openSession();
		//get
		Student stud = session.load(Student.class, 102);
		System.out.println(stud);
		Address add = session.get(Address.class, 1);
		System.out.println(add.getStreet());
		
		
		session.close();
		factory.close();

	}
}

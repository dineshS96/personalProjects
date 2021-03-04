package com.tut.ProjectWithMaven;

import java.util.Date;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project started!!");
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// factory.getCurrentSession();
		System.out.println(factory);
		// creating student
		Student st = new Student();
		st.setId(102);
		st.setName("Joe");
		st.setCity("Dehradun");
		System.out.println(st);
		
		//object of address
		Address ad = new Address();
		ad.setStreet("Street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.45);
		
		//reading image
		FileInputStream fis = new FileInputStream("src/main/java/picture.jpg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();

		session.clear();
		System.out.println("Done");
	}
}

package com.tut.ProjectWithMaven;

import java.beans.Transient;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student student1 = new Student();
		student1.setId(11);
		student1.setName("Dinesh mishra");
		student1.setCity("Mumbai");
		Certificate certificate = new Certificate();
		certificate.setCourse("android");
		certificate.setDuration("2 months");
		student1.setCerti(certificate);

		Student student2 = new Student();
		student2.setId(12);
		student2.setName("Pratyush godbole");
		student2.setCity("Nagpur");
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("hibernate");
		certificate1.setDuration("2.5 months");
		student1.setCerti(certificate1);
		
		
		Session s=factory.openSession();
		org.hibernate.Transaction tx= s.beginTransaction();
		
		//objects save
		s.save(student1);
		s.save(student2);
		
		
		tx.commit();
		s.close();
		
		
		factory.close();
	}
}

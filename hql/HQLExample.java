package com.hql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		//HQL
		//syntax
		String query="from Student where city=:x";
		Query q= s.createQuery(query);
		q.setParameter("x", "Pune");
		//single - unique
		//multiple - list
		List<Student> list = q.list();
		for(Student student:list)
		{
			System.out.println(student.getName());
		}
		System.out.println("--------");
		org.hibernate.Transaction tx=s.beginTransaction();
		
		//Delete query
//		Query q2 = s.createQuery("delete from Student where city=:c");
//		q2.setParameter("c","Mumbai");		
//		int r = q2.executeUpdate();
//		System.out.println("Deleted");
//		System.out.println(r);
		
		//update query
		Query q3 = s.createQuery("Update Student set city=:c where name=:n");
		q3.setParameter("c", "Delhi");
		q3.setParameter("n", "Pratyush");
		int r1 = q3.executeUpdate();
		System.out.println(r1+ "Objects updated");
		tx.commit();
		
		
		//join query
		Query q4 = s.createQuery("select q.question, q.questionId, a.answer from Question as q inner join q.answers as a");
		
		List<Object[]> list3 = q4.getResultList();
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
		
	}
}

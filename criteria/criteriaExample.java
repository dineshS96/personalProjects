package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.ProjectWithMaven.Student;

public class criteriaExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Criteria c = s.createCriteria(Student.class);
		Criteria add = c.add(Restrictions.eq("city","agra"));
		System.out.println(add);
		List<Student> list = c.list();
		for(Student st:list)
		{
			System.out.println(st);
		}
		
		
		s.close();
		factory.close();
	}
}

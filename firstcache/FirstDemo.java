package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.internal.ConfigLoader;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		//by default enabled
		Student student = s.get(Student.class, 1);
		System.out.println(student.getName());
		System.out.println("----");
		Student student2 = s.get(Student.class, 1);
		System.out.println(student2.getName());
		
		System.out.println(s.contains(student2));
		
		s.close();
		factory.close();
	}
}

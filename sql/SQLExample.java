package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.ProjectWithMaven.Student;

public class SQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		String q="select * from mystudents";
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> list = nq.list();
		for(Object[] st:list)
		{
			System.out.println(st[4]+" : "+st[3]);
		}
		
		s.close();
		factory.close();
	}
}

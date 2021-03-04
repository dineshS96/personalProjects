package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.ProjectWithMaven.Student;

public class HQLPagination {
		public static void main(String[] args) {
			Configuration cfg = new Configuration().configure();
			SessionFactory factory = cfg.buildSessionFactory();
			Session s = factory.openSession();
			Query q = s.createQuery("from Student");
			
			//implementing pagination using hibernate
			q.setFirstResult(0);
			q.setMaxResults(4);
			
			List<Student> list = q.list();
			
			for(Student st:list)
			{
				System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
			}
			
			s.close();
			factory.close();
		}
}

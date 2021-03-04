package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is JAVA");
		
		// creating answer
		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("JAVA is programming language");
		ans.setQ(q1);
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(363);
		ans1.setAnswer("With the help of java we can create softwares");
		ans1.setQ(q1);
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(313);
		ans2.setAnswer("With the help of java we can create softwares");
		ans2.setQ(q1);
		
		List<Answer> list=new ArrayList<>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswers(list);
		
		//q1.setAnswer(ans);
 
		// creating question
		/*
		 * Question q2 = new Question(); q2.setQuestionId(242);
		 * q2.setQuestion("What is collection framework");
		 * 
		 * // creating answer Answer ans1 = new Answer(); ans1.setAnswerId(344);
		 * ans1.setAnswer("API to work with objects in JAVA"); ans1.setQ(q2);
		 * q2.setAnswer(ans1);
		 */

		// session save
		Session s = factory.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		s.save(q1);
		s.save(ans);
		s.save(ans1);
		s.save(ans2);
		/*
		 * s.save(q1); s.save(q2); s.save(ans); s.save(ans1);
		 */

		tx.commit();
		//fetching
		/*
		 * Question newQ = s.get(Question.class, 1212);
		 * System.out.println(newQ.getQuestion()); 
		 * System.out.println(newQ.getAnswer());
		 */
		Question q=(Question)s.get(Question.class, 1212);
		q.getQuestion();
		for(Answer a:q.getAnswers())
		{
		System.out.println(a.getAnswer());
		}
		s.close();

		factory.close();
	}
}

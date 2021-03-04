package com.JDBCDemo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.glass.ui.Application;

public class test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		studentDAQ studentDaq = context.getBean("studentDAQ",studentDAQ.class);
		System.out.println(studentDaq);
		studentDaq.selectAllRows();
		((ClassPathXmlApplicationContext)context).close();
		
	}
}

package com.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class studentDAQ {

	private String driver;
	private String url;
	private String username;
	private String password;

	Connection con;

	public void setDriver(String driver) {
		System.out.println("Stting driver...");
		this.driver = driver;
	}

	public void setUrl(String url) {
		System.out.println("Setting url..");
		this.url = url;
	}

	public void setUsername(String username) {
		System.out.println("Setting username...");
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("setting password..");
		this.password = password;
	}

	//@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("Inside the init method");
		createStudentDBConnection();
	}

	public void createStudentDBConnection() throws SQLException, ClassNotFoundException {
		System.out.println("Creating connection for studentDB");
		// load driver
		Class.forName(driver);

		// get a connection
		con = DriverManager.getConnection(url, username, password);
	}

	public void selectAllRows() throws ClassNotFoundException, SQLException {
		System.out.println("Retrieving all students data..");

		// execute query
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String gender = rs.getString(3);
			String age = rs.getString(4);
			System.out.println(id + " " + name + " " + gender + " " + age);

		}

	}

	public void deleteStudentRecord(int customerNumber) throws ClassNotFoundException, SQLException {

		// execute query
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from student where id =  " + customerNumber);
		System.out.println("Record deleted with the id " + customerNumber);

	}

	
	public void closeConnection() throws SQLException {
		System.out.println("Destroy method..");
		con.close();
	}
	
	//@PreDestroy
	public void destroy() throws SQLException {
		System.out.println("inside destroy method");
		closeConnection();
	}
}

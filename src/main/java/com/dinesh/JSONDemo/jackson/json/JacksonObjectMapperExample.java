package com.dinesh.JSONDemo.jackson.json;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dinesh.JSONDemo.model.Address;
import com.dinesh.JSONDemo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonObjectMapperExample {
public static void main(String[] args) throws IOException {
	//read json file data to String
	byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\dineshs\\Desktop\\employee.txt"));
	
	//create ObjectMapper instance
	ObjectMapper objectMapper = new ObjectMapper();
	
	//convert json string to object
	Employee emp = objectMapper.readValue(jsonData, Employee.class);
	
	//System.out.println("Employee object\n" +emp);
	
	//convert object to json string
	//Employee emp1=createEmployee();
	
	//configure object mapper for pretty print
	objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	
	//writing to console , can write to any output stream such as file
	StringWriter stringEmp= new StringWriter();
	objectMapper.writeValue(stringEmp, emp);
	System.out.println("Employee JSON is\n" +stringEmp);
	
}

/*
 * private static Employee createEmployee() { Employee emp = new Employee();
 * emp.setId(100); emp.setName("David"); emp.setPermanent(false);
 * emp.setPhoneNumbers(new long[] {123456, 987684});
 * 
 * emp.setRole("Manager");
 * 
 * Address add = new Address(); add.setCity("Bangalore");
 * add.setStreet("BTM 1st Stage"); add.setZipcode(560100); emp.setAddress(add);
 * 
 * List<String> cities=new ArrayList<String>(); cities.add("LA");
 * cities.add("NY"); emp.setCities(cities);
 * 
 * HashMap<String, String> props = new HashMap<String,String>();
 * props.put("salary", "1000 Rs"); props.put("age", "28 years");
 * emp.setProperties(props); return emp;
 * 
 * }
 */
}

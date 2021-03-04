package com.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Todo;

@Component
public class TodoDao {
	@Autowired
HibernateTemplate hibernateTemplate;
	
	
	public int save(Todo t)
	{
		Integer i = (Integer) hibernateTemplate.save(t);
		return i;
		
	}
	
	public List<Todo> getAll()
	{
		List<Todo> todos = hibernateTemplate.loadAll(Todo.class);
		return todos;
		
	}
}

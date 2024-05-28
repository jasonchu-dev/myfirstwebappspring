package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//use jpa to show list of todos from data.sql
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	//requires default constructor in Todo.java otherwise error
	public List<Todo> findByUsername(String username);	
}

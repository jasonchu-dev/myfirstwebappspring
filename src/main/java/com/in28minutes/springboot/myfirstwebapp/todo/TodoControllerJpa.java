package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//backup controller
@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	@Autowired
	private TodoRepository todoRepository;
	
	//handles get and post
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	//seperate handling for post and get
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		//whatever is in 3rd param will show up on textbox
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		//get todo from todo.jsp line 19
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	//@Valid will apply line 12 from Todo.java
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		//if BindingResult is not used, the browser will go to an error page bc the validation is applied but there's no fallback on what to do after failed validation
		//go to same "todo" page but in todo.jsp add an error form that routes to @Size in Todo.java. Browser will say message
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		//populate values in table with save method
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	//@Valid will apply line 12 from Todo.java
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		//if BindingResult is not used, the browser will go to an error page bc the validation is applied but there's no fallback on what to do after failed validation
		//go to same "todo" page but in todo.jsp add an error form that routes to @Size in Todo.java. Browser will say message
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		//use redirect otherwise if just returning list-todos then list would be empty
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}

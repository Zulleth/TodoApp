package com.zr.MyToDoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zr.MyToDoApp.model.Task;
import com.zr.MyToDoApp.service.TaskServiceImp;

@RestController
@RequestMapping("/api")
public class TaskApiController {
	
	@Autowired
	TaskServiceImp service; 
	
	@GetMapping("/tasks")
	public List<Task> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/task/{id}")
	public Task findById(@PathVariable("id") Long id) {
		return service.findTaskById(id);
	}
	@PostMapping("/task/new")
	public String createTask(Task task){
		service.saveTask(task);
		return "Message Created Successfully";
	}
	
	@DeleteMapping("/task/{id}")
	public String deleteTaskById(@PathVariable("id") Long id) {
		service.deleteTaskById(id);
		return "Task deleted Successfully";
	}
	
	@PostMapping("/task/{id}")
	public String updateTaskById(@PathVariable("id") Long id, Task task) {
		service.updateTaskById(id, task);
		return "Task updated Successfully";
	}
	
	


	

}

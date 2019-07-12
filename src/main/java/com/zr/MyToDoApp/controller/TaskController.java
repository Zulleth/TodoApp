package com.zr.MyToDoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zr.MyToDoApp.model.Task;
import com.zr.MyToDoApp.service.TaskServiceImp;

@Controller 
public class TaskController {

	@Autowired
	private TaskServiceImp service;
	
	@GetMapping("/tasks")
	public String getAllTasks(Model model, Task task){
		List<Task> tasks = service.findAll();
		model.addAttribute("allTasks", tasks);
		return "taskList";
	}
	
	@GetMapping("/task/new")
	public String getTaskForm(Task task){
		return "newTask";
	}
	
	@PostMapping("/task/new")
	public String createTask(Task task, Model model){
		service.saveTask(task);
		model.addAttribute("task", new Task());
		model.addAttribute("message", "Task created Successfully");
		return "newTask";
	}
	
	@DeleteMapping("/task/{id}")
	public String deleteTaskById(@PathVariable("id") Long id, Model model) {
		service.deleteTaskById(id);
		model.addAttribute("message", "Task deleted Successfully");
		return "result";
	}
	
	
	@GetMapping("/task/{id}/update")
	public String updateForm(@PathVariable("id") Long id, Task task, Model model) {
		Task currentTask = service.findTaskById(id);
		model.addAttribute("currentTask", currentTask);
		return "updateTask";
	}
	
	@PostMapping("/task/{id}")
	public String updateTaskById(@PathVariable("id") Long id, Task task, Model model) {
		service.updateTaskById(id, task);
		model.addAttribute("message", "Task updated Successfully");
		return "result";
	}
	
}

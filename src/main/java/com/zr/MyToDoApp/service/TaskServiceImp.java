package com.zr.MyToDoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zr.MyToDoApp.model.Task;
import com.zr.MyToDoApp.repository.TaskRepository;

@Service 
public class TaskServiceImp implements TaskServiceInt{
	
	@Autowired
	private TaskRepository repository;
	
	@Override
	public List<Task> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Task findTaskById(Long id) {
		return repository.findTaskById(id);
	}
	
	@Override
	public void saveTask(Task task) {
		repository.save(task);
	}
	
	@Override
	public void deleteTaskById(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public void updateTaskById(Long id, Task taskData) {
		Task taskToReplace = repository.findTaskById(id);
		Boolean completed = taskData.getCompleted();
		if(completed = false) taskToReplace.setCompleted(false);
		if(completed = true) taskToReplace.setCompleted(true);
		repository.save(taskToReplace);
	}

	public void deleteAllTasks() {
		repository.deleteAll();
	}

	

}

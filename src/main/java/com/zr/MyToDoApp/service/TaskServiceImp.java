package com.zr.MyToDoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zr.MyToDoApp.model.Task;
import com.zr.MyToDoApp.repository.TaskRepository;

@Service 
public class TaskServiceImp implements TaskServiceInt{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	@Override
	public Task findTaskById(Long id) {
		return taskRepository.findTaskById(id);
	}
	
	@Override
	public void saveTask(Task task) {
		taskRepository.save(task);
	}
	
	@Override
	public void deleteTaskById(Long id) {
		taskRepository.deleteById(id);
	}
	
	@Override
	public void updateTaskById(Long id, Task taskData) {
		Task taskToReplace = taskRepository.findTaskById(id);
		Boolean completed = taskData.getCompleted();
		if(completed = false) taskToReplace.setCompleted(false);
		if(completed = true) taskToReplace.setCompleted(true);
		taskRepository.save(taskToReplace);
	}

	

}

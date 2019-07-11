package com.zr.MyToDoApp.service;

import java.util.List;

import com.zr.MyToDoApp.model.Task;

public interface TaskServiceInt {
	
	public Task findTaskById(Long id);
	public List<Task> findAll();
	public void saveTask(Task task);
	public void deleteTaskById(Long id);
	public void updateTaskById(Long id, Task taskData);

}

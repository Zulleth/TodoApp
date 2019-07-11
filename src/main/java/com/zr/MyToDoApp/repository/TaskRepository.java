package com.zr.MyToDoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zr.MyToDoApp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	public Task findTaskByTitle(String title);
	public Task findTaskById(Long id);
	public List<Task> findAll();
	public List<Task> findAllTasksByCompleted(Boolean completed);
}

package com.zr.MyToDoApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zr.MyToDoApp.model.Task;
import com.zr.MyToDoApp.repository.TaskRepository;
import com.zr.MyToDoApp.service.TaskServiceImp;
import com.zr.MyToDoApp.service.TaskServiceInt;

@RunWith(SpringRunner.class)
public class TaskServiceTest {
	
	@Configuration
	static class ServiceConfiguration{
		@Bean
		public TaskServiceInt configuration(){
			return new TaskServiceImp();
		}
	}
	private static Task task1;
	private static Task task2;
	private static List<Task> taskList;

	
	@Autowired
	TaskServiceInt service;
	
	@MockBean
	TaskRepository repository;
	
	@Before
	public void setUp(){
		task1 = new Task("Homework", "study", "Zulleth");
		task2 = new Task("practice", "java", "Viviana");

		taskList = new ArrayList<>();
		taskList.add(task2);
		
		taskList = new ArrayList<>( Arrays.asList(task1, task2) );

	}
	
	@Test
	public void givenJokeId_returnJoke() {
		Mockito.when(repository.findTaskById(task1.getId())).thenReturn(task1);

		Task found = service.findTaskById(task1.getId());
		
		assertThat(task1).isEqualToComparingFieldByField(found);		
	}
	
	@Test
	public void givenJokes_returnAllJokes() {
		Mockito.when(repository.findAll()).thenReturn(taskList);

		List<Task> found = service.findAll();
		
		assertEquals(taskList, found);
	}
	
	

}

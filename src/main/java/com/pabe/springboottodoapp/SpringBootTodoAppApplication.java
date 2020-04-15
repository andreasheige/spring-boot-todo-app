package com.pabe.springboottodoapp;

import java.util.Arrays;
import java.util.Collection;

import com.pabe.springboottodoapp.domain.Todo;
import com.pabe.springboottodoapp.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTodoAppApplication implements CommandLineRunner {

	@Autowired
	public TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Collection<Todo> todos = Arrays.asList(new Todo("Drink coffee", "Yes"), new Todo("Take a nap", "Yes"), new Todo("Buy new car", "No"));
		todos.forEach(todoRepository::save);
	}

}

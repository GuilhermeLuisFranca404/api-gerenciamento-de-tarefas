package io.github.GuilhermeLuisFranca404.todo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.GuilhermeLuisFranca404.todo.model.Todo;
import io.github.GuilhermeLuisFranca404.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api-rest/todos")
@CrossOrigin(origins = {"http://localhost:8080/api-rest/todos/", "*"})
public class Controller {

	@Autowired
	private TodoRepository repository;


	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		if (todo.getDone() == null) todo.setDone(false);
		return repository.save(todo);
	}



	@GetMapping
	public List<Todo> findAllWithoutMarkDone(){
		return repository.findAllWithoutMarkDone();
	}

	@GetMapping("finalized")
	public List<Todo> findAllWithMarkDone(){
		return repository.findAllWithMarkDone();
	}



	@PatchMapping("{id}/done")
	public Todo markAsDone(@PathVariable Long id) {
		return repository.findById(id).map(todo -> {
			todo.setDone(true);
			todo.setDoneDate(LocalDateTime.now());
			repository.save(todo);
			return todo;
		}).orElse(null);
	}

}
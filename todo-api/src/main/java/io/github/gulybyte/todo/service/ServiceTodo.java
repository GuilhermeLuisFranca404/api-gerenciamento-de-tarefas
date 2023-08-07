package io.github.gulybyte.todo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import io.github.gulybyte.todo.model.Todo;

public interface ServiceTodo {

    Todo save(Todo todo);

	List<Todo> findAllWithoutMarkDoneNonPageable();
	Page<Todo> findAllWithMarkDone(int pageNumber);

	void deleteById(Long id);

	Todo markAsDone(Long id);
	Todo changeOrderById(Long id);
	Todo undoneMarkAsDone(Long id);
    Todo updateDescriptionById(Long id, String description);

}

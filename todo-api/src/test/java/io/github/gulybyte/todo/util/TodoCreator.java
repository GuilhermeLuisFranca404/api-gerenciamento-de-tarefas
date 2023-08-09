package io.github.gulybyte.todo.util;

import java.time.LocalDateTime;

import io.github.gulybyte.todo.filter.body.TodoPutFilter;
import io.github.gulybyte.todo.model.Todo;

public class TodoCreator {

    private static final Long DEFAULT_LONG = 1L;
    private static final String DEFAULT_STRING = "any String";
    private static final Boolean DEFAULT_BOOLEAN = null;
    private static final LocalDateTime DEFAULT_DATE = null;


    public static Todo createTodoWithDoneFalse(){
        return Todo.builder()
                .description(DEFAULT_STRING)
                .done(false)
                .createdDate(DEFAULT_DATE)
                .doneDate(DEFAULT_DATE)
                .orderTodo(DEFAULT_DATE)
                .build();
    }

    public static Todo createTodoWithDoneTrue(){
        return Todo.builder()
                .description(DEFAULT_STRING)
                .done(true)
                .createdDate(DEFAULT_DATE)
                .doneDate(DEFAULT_DATE)
                .orderTodo(DEFAULT_DATE)
                .build();
    }

    public static Todo createTodoWithCreateDateAndOrderTodoIsNull(){
        return Todo.builder()
                .description(DEFAULT_STRING)
                .done(DEFAULT_BOOLEAN)
                .createdDate(null)
                .doneDate(DEFAULT_DATE)
                .orderTodo(null)
                .build();
    }

    public static Todo createTodoDefault(){
        return Todo.builder()
                .description(DEFAULT_STRING)
                .done(DEFAULT_BOOLEAN)
                .createdDate(DEFAULT_DATE)
                .doneDate(DEFAULT_DATE)
                .orderTodo(DEFAULT_DATE)
                .build();
    }

    public static TodoPutFilter createTodoPutFilterDefault(){
        return TodoPutFilter.builder()
                .id(DEFAULT_LONG)
                .description(DEFAULT_STRING)
                .build();
    }

    public static TodoPutFilter createTodoPutFilterWithNewDescription(){
        return TodoPutFilter.builder()
                .id(DEFAULT_LONG)
                .description("new description")
                .build();
    }

}

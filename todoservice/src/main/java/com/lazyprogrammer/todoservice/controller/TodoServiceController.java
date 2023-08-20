package com.lazyprogrammer.todoservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lazyprogrammer.todoservice.dto.SubTaskRequest;
import com.lazyprogrammer.todoservice.dto.TodoItemRequest;
import com.lazyprogrammer.todoservice.dto.TodoItemResponse;
import com.lazyprogrammer.todoservice.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoServiceController {
    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodoItem(@RequestBody TodoItemRequest todoItemRequest) {
        todoService.createTodoItem(todoItemRequest);
    }

    @GetMapping
    public List<TodoItemResponse> getTodoItems() {
        return todoService.getTodoItems();
    }

    @GetMapping("/{id}")
    public TodoItemResponse getTodoItem(@PathVariable Long id) {
        return todoService.getTodoItem(id);
    }

    @PostMapping("/{id}/createSubTask")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubTask(@PathVariable Long id, @RequestBody SubTaskRequest subTaskRequest){
        todoService.createSubTask(id, subTaskRequest);
    }
}

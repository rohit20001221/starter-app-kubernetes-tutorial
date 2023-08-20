package com.lazyprogrammer.todoservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lazyprogrammer.todoservice.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {}

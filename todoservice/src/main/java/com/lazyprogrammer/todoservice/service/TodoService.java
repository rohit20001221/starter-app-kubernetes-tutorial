package com.lazyprogrammer.todoservice.service;

import com.lazyprogrammer.todoservice.dto.SubTaskRequest;
import com.lazyprogrammer.todoservice.dto.TodoItemRequest;
import com.lazyprogrammer.todoservice.dto.TodoItemResponse;
import com.lazyprogrammer.todoservice.model.SubTask;
import com.lazyprogrammer.todoservice.model.TodoItem;
import com.lazyprogrammer.todoservice.repository.SubTaskRepository;
import com.lazyprogrammer.todoservice.repository.TodoItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

  private final TodoItemRepository todoItemRepository;
    private final SubTaskRepository subTaskRepository;

  public void createTodoItem(TodoItemRequest todoItemRequest) {
    TodoItem todoItem = TodoItem
      .builder()
      .title(todoItemRequest.getTitle())
      .description(todoItemRequest.getDescription())
      .build();
    todoItemRepository.save(todoItem);

    log.info("create todo item {}", todoItem.getId());
  }

  public List<TodoItemResponse> getTodoItems() {
    List<TodoItemResponse> todoItemsList = todoItemRepository
      .findAll()
      .stream()
      .map(this::mapToTodoItemResponse)
      .collect(Collectors.toList());

    return todoItemsList;
  }

  public TodoItemResponse getTodoItem(Long id) {
    TodoItem item = todoItemRepository.findById(id).orElse(null);

    if (item != null) {
        return this.mapToTodoItemResponse(item);
    }

    return null;
  }

  public void createSubTask(Long id, SubTaskRequest subTask) {
    boolean item = todoItemRepository.existsById(id);

    if (item) {
        SubTask _subTask = SubTask
        .builder()
        .todoItemId(id)
        .name(subTask.getName())
        .build();

        subTaskRepository.save(_subTask);
    }
  }

  public TodoItemResponse mapToTodoItemResponse(TodoItem item) {
    return TodoItemResponse
      .builder()
      .id(item.getId())
      .description(item.getDescription())
      .title(item.getTitle())
      .subTasks(item.getSubTasks())
      .build();
  }
}

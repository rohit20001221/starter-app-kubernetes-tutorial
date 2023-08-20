package com.lazyprogrammer.todoservice.service;

import com.lazyprogrammer.todoservice.events.TodoItemCreatedEvent;
import com.lazyprogrammer.todoservice.model.TodoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

  private final KafkaTemplate<String, TodoItemCreatedEvent> kafkaTemplate;

  public void sendMessage(String topic, TodoItem todoItem) {
    TodoItemCreatedEvent event = TodoItemCreatedEvent
      .builder()
      .todoItemId(todoItem.getId())
      .message("item created !")
      .build();
    
    kafkaTemplate.send(topic, event);
  }
}

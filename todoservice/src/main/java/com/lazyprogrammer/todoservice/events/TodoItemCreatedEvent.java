package com.lazyprogrammer.todoservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItemCreatedEvent {
    private Long todoItemId;
    private String message;
}

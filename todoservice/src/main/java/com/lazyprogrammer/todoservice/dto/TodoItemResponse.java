package com.lazyprogrammer.todoservice.dto;

import java.util.List;

import com.lazyprogrammer.todoservice.model.SubTask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItemResponse {
    private Long id;
    private String title;
    private String description;

    private List<SubTask> subTasks;
}

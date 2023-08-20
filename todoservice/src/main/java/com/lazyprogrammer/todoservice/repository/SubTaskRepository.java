package com.lazyprogrammer.todoservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lazyprogrammer.todoservice.model.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {}

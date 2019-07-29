package com.devhouse.crashtodo.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    TaskRepository taskRepository;

    public Task createTask(TaskCreateDto requested) {

        Task newTask = Task.builder().title(requested.getTitle()).build();

        return taskRepository.save(newTask);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}

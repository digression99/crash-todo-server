package com.devhouse.crashtodo.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Task updateTask(int taskId, TaskUpdateDto updateTask) {
        Optional<Task> prevTaskOpt = taskRepository.findById(taskId);

        if (prevTaskOpt.isEmpty()) {
            return null;
        }

        Task prevTask = prevTaskOpt.get();

        prevTask.setTitle(updateTask.getTitle());

        return taskRepository.save(prevTask);
    }

    public Optional<Task> removeTask(int taskId) {
        Optional<Task> deletedTask = taskRepository.findById(taskId);
        taskRepository.deleteById(taskId);
        return deletedTask;
    }
}

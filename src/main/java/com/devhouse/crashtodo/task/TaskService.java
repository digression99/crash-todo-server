package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService {

    TaskRepository taskRepository;

    public Task createTask(TaskCreateDto requested) {

        Task newTask = Task.builder()
                .title(requested.getTitle())
                .taskStatus(TaskStatus.CREATED)
                .build();

        return taskRepository.save(newTask);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTitle(int taskId, TitleUpdateDto titleUpdateDto) {
        Optional<Task> prevTaskOpt = taskRepository.findById(taskId);

        if (prevTaskOpt.isEmpty()) {
            return null;
        }

        Task prevTask = prevTaskOpt.get();

        prevTask.setTitle(titleUpdateDto.getTitle());

        return taskRepository.save(prevTask);
    }

    Task updateTaskStatusToDeleted(int taskId) {
        return updateTaskStatus(taskId, TaskStatus.DELETED);
    }

    Task updateTaskStatusToCreated(int taskId) {
        return updateTaskStatus(taskId, TaskStatus.CREATED);
    }

    Task updateTaskStatus(int taskId, TaskStatus taskStatus) {
        Optional<Task> prevTaskOpt = taskRepository.findById(taskId);

        if (prevTaskOpt.isEmpty()) {
            return null;
        }

        Task prevTask = prevTaskOpt.get();

        prevTask.setTaskStatus(taskStatus);

        return taskRepository.save(prevTask);
    }

    public Task updateTask(int taskId, TaskUpdateDto taskUpdateDto) {
        switch(taskUpdateDto.getName()) {
            case "deleted":
                return updateTaskStatusToDeleted(taskId);
            case "created":
                return updateTaskStatusToCreated(taskId);
            case "title":
                return updateTitle(taskId, (TitleUpdateDto) taskUpdateDto);
            default:
                return null;
        }
    }
}

package com.devhouse.crashtodo.task;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    @GetMapping("")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public Task createTask(@RequestBody TaskCreateDto newTask) {
        return taskService.createTask(newTask);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") int taskId, @RequestBody TaskUpdateDto taskUpdateDto) {
        return taskService.updateTask(taskId, taskUpdateDto);
    }
}

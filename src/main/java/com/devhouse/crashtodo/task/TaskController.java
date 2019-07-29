package com.devhouse.crashtodo.task;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Task updateTask(@PathVariable("id") int taskId, @RequestBody TaskUpdateDto updateTask) {
        return taskService.updateTask(taskId, updateTask);
    }

}

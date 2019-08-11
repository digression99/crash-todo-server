package com.devhouse.crashtodo.task;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") int taskId) {
        Optional<Task> removedTaskOpt = taskService.removeTask(taskId);

        if (removedTaskOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(removedTaskOpt.get());
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

package com.devhouse.crashtodo.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskServiceTest {

    private TaskService taskService;
    private TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    public void createTask() {
    }

    @Test
    public void getAllTasks() {
    }
}
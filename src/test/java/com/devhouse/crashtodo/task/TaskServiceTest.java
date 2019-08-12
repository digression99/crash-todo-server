package com.devhouse.crashtodo.task;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class TaskServiceTest {

    public static final int MOCK_TASK_ID = 1;
    public static final String MOCK_TASK_TITLE = "testTitle";
    private TaskService taskService;
    private TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    public void createTask() {
        TaskCreateDto taskCreateDto = TaskCreateDto.builder().title(MOCK_TASK_TITLE).build();

        taskService.createTask(taskCreateDto);

        Task newTask = Task.builder()
                           .title(MOCK_TASK_TITLE)
                           .taskStatus(TaskStatus.CREATED)
                           .build();

        verify(taskRepository).save(newTask);
    }

    @Test
    public void getAllTasks() {
        taskService.getAllTasks();
        verify(taskRepository).findAll();
    }

    @Test
    public void updateTitle() {
        final Task mockPrevTask = Task.builder()
                                      .id(MOCK_TASK_ID)
                                      .title(MOCK_TASK_TITLE)
                                      .taskStatus(TaskStatus.CREATED)
                                      .build();

        when(taskRepository.findById(MOCK_TASK_ID)).thenReturn(Optional.of(mockPrevTask));

        taskService.updateTitle(MOCK_TASK_ID, TitleUpdateDto.builder().title("newTitle").build());

        final Task updatedTask = Task.builder()
                                     .id(MOCK_TASK_ID)
                                     .title("newTitle")
                                     .taskStatus(TaskStatus.CREATED)
                                     .build();

        verify(taskRepository).save(updatedTask);
    }

    @Test
    public void updateTitle_taskNotFound() {
        when(taskRepository.findById(MOCK_TASK_ID)).thenReturn(Optional.empty());

        taskService.updateTitle(MOCK_TASK_ID, mock(TitleUpdateDto.class));

        verify(taskRepository, never()).save(any());
    }
}

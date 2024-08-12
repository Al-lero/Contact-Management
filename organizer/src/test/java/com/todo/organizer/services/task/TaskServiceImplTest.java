package com.todo.organizer.services.task;

import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.request.DeleteTaskRequest;
import com.todo.organizer.dto.request.FindTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import com.todo.organizer.dto.response.DeleteTaskResponse;
import com.todo.organizer.dto.response.FindTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @BeforeEach
    void cleanup() {
      taskRepository.deleteAll();
    }

    @Test
    public void testThatTaskCanBeCreated(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setName("savings");
        createTaskRequest.setUser("ojo");
        createTaskRequest.setStatus("Status");
        createTaskRequest.setDescription("for long time");
        createTaskRequest.setDateCreated("2023-04-20T10:15:30");

        CreateTaskResponse response = taskService.createTask(createTaskRequest);

        assertEquals(1,taskRepository.count());
        assertNotNull(response);
        assertTrue(response.getMessage().contains("Task Created"));
    }

    @Test
    public void testThatTaskCanBeFoundById(){
        Task task = new Task();
        task.setName("savings");
        task.setDescription("for a long time");
        task.setId("66b8cfc95dee1f57d768f4ea");
        taskRepository.save(task);
        FindTaskRequest findTaskRequest = new FindTaskRequest();
        findTaskRequest.setId("66b8cfc95dee1f57d768f4ea");
        FindTaskResponse response = taskService.findTask(findTaskRequest);
        assertTrue(response.getMessage().contains("Task Found"));
    }

    @Test
    public void testThatTaskCanBeDeletedById(){
        Task task = new Task();
        task.setName("savings");
        task.setDescription("for a long time");
        task.setId("66b8cfc95dee1f57d768f4ea");
        taskRepository.save(task);
        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setId("66b8cfc95dee1f57d768f4ea");
        DeleteTaskResponse response = taskService.deleteTask(deleteTaskRequest);
        assertTrue(response.getMessage().contains("Task Deleted SuccessFully"));
    }
}
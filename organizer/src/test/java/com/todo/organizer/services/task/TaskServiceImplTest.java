package com.todo.organizer.services.task;

import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.request.DeleteTaskRequest;
import com.todo.organizer.dto.request.FindTaskRequest;
import com.todo.organizer.dto.request.UpdateTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import com.todo.organizer.dto.response.DeleteTaskResponse;
import com.todo.organizer.dto.response.FindTaskResponse;
import com.todo.organizer.dto.response.UpdateTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
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


        CreateTaskResponse response = taskService.createTask(createTaskRequest);

        assertEquals(1,taskRepository.count());
        assertNotNull(response);
        assertTrue(response.getMessage().contains("Task Created"));
    }

    @Test
    public void testThatTaskCanBeFoundById(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setName("savings");
        createTaskRequest.setUser("ojo");
        createTaskRequest.setStatus("Status");
        createTaskRequest.setDescription("for long time");
        CreateTaskResponse response1 = taskService.createTask(createTaskRequest);
        FindTaskRequest findTaskRequest = new FindTaskRequest();
        findTaskRequest.setId(response1.getId());
        FindTaskResponse response = taskService.findTask(findTaskRequest);
        assertTrue(response.getMessage().contains("Task Found"));
    }

    @Test
    public void testThatTaskCanBeDeletedById(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setName("savings");
        createTaskRequest.setUser("ojo");
        createTaskRequest.setStatus("Status");
        createTaskRequest.setDescription("for long time");
        CreateTaskResponse response1 = taskService.createTask(createTaskRequest);
        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setId(response1.getId());
        DeleteTaskResponse response = taskService.deleteTask(deleteTaskRequest);
        assertTrue(response.getMessage().contains("Task Deleted SuccessFully"));
    }

    @Test
    public void testThatTaskCanBeUpdated(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setName("savings");
        createTaskRequest.setUser("ojo");
        createTaskRequest.setStatus("Status");
        createTaskRequest.setDescription("for long time");
        CreateTaskResponse response1 = taskService.createTask(createTaskRequest);
        UpdateTaskRequest request = new UpdateTaskRequest();
        request.setId(response1.getId());
        request.setUser("user");
        request.setName("savings");
        request.setDescription("erfjfjff");
        UpdateTaskResponse response = taskService.updateTask(request);
        assertThat(response.getMessage()).contains("Updated Successfully");
    }
}
package com.todo.organizer.services.task;

import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.request.DeleteTaskRequest;
import com.todo.organizer.dto.request.FindTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import com.todo.organizer.dto.response.DeleteTaskResponse;
import com.todo.organizer.dto.response.FindTaskResponse;

public interface TaskService {
    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);

    FindTaskResponse findTask(FindTaskRequest findTaskRequest);

    DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);
}

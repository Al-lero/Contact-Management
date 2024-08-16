package com.todo.organizer.services.task;


import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.request.DeleteTaskRequest;
import com.todo.organizer.dto.request.FindTaskRequest;
import com.todo.organizer.dto.request.UpdateTaskRequest;
import com.todo.organizer.dto.response.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        if(taskExist(createTaskRequest.getName())){
            throw new RuntimeException("Task already Exists");
    }
        Task task = new Task();
        task.setName(createTaskRequest.getName());
        task.setDescription(createTaskRequest.getDescription());
        task.setCreatedAt(LocalDateTime.now());
        Task save = taskRepository.save(task);

        CreateTaskResponse response = new CreateTaskResponse();
        response.setId(task.getId());
        response.setMessage("Task Created");
        return response;


}

    @Override
    public FindTaskResponse findTask(FindTaskRequest findTaskRequest) {
        if(findById(findTaskRequest.getId()).isEmpty()){
            throw new RuntimeException("Task Not Found");
        }

        Task task = findById(findTaskRequest.getId()).get();
        taskRepository.findAll();

        FindTaskResponse response = new FindTaskResponse();
        response.setMessage("Task Found");
        return response;

    }

    @Override
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        if(findById(deleteTaskRequest.getId()).isEmpty()){
            throw new RuntimeException("No Task Found");
        }

        Task task = findById(deleteTaskRequest.getId()).get();
        taskRepository.delete(task);

        DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("Task Deleted SuccessFully");
        return response;
    }

    @Override
    public UpdateTaskResponse updateTask(UpdateTaskRequest request) {
        Task task = findById(request.getId())
                .orElseThrow(()->new RuntimeException("Task not found"));
        task.setName(request.getNewName());
        task.setUser(request.getUser());
        task.setDescription(request.getDescription());
        taskRepository.save(task);
        UpdateTaskResponse response = new UpdateTaskResponse();
        response.setMessage("Updated Successfully");
        return response;
    }

    private Task findByName(String name) {
        return taskRepository.findByName(name);
    }

    private Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }




    private boolean taskExist(String taskName) {
        return taskRepository.findByName(taskName)!=null;
    }


    }

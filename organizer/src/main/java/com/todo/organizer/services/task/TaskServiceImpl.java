package com.todo.organizer.services.task;


import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.request.DeleteTaskRequest;
import com.todo.organizer.dto.request.FindTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import com.todo.organizer.dto.response.DeleteTaskResponse;
import com.todo.organizer.dto.response.FindTaskResponse;
import com.todo.organizer.dto.response.FindUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;


    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        if(taskExist(createTaskRequest.getName())){
            throw new RuntimeException("Task already Exists");
    }
        Task task = new Task();
        task.setName(createTaskRequest.getName());
        task.setDescription(createTaskRequest.getDescription());
        task.setCreatedAt(LocalDateTime.parse(createTaskRequest.getDateCreated()));
        Task save = taskRepository.save(task);

        CreateTaskResponse response = new CreateTaskResponse();
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

    private Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }




    private boolean taskExist(String taskName) {
        return taskRepository.findByName(taskName)!=null;
    }


    }

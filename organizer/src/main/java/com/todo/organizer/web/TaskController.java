package com.todo.organizer.web;

import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.*;
import com.todo.organizer.dto.response.*;
import com.todo.organizer.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/create")
    public ResponseEntity <?> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        try{
            CreateTaskResponse createTaskResponse = taskService.createTask(createTaskRequest);
            return new ResponseEntity<>(createTaskResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest){
        try{
            DeleteTaskResponse deleteTask = taskService.deleteTask(deleteTaskRequest);
            return new ResponseEntity<>(deleteTask, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("findTask")
    public ResponseEntity<?> findTask(@RequestBody FindTaskRequest findTaskRequest){
        try {
            FindTaskResponse findTask = taskService.findTask(findTaskRequest);
            return new ResponseEntity<>(findTask, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

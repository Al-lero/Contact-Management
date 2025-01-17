package com.todo.organizer.web;

import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.*;
import com.todo.organizer.dto.response.*;
import com.todo.organizer.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.tokens.ScalarToken;

import java.util.List;


@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
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

    @PatchMapping("updateTask")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest){
        try{
            UpdateTaskResponse updateTask = taskService.updateTask(updateTaskRequest);
            return new ResponseEntity<>(updateTask, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(){
       try {
           List<Task> findAllTasks = taskService.findAllTasks();
           return new ResponseEntity<>(new ResponseApi(true, findAllTasks),
                   HttpStatus.OK);
       }
       catch (Exception exception){
           return new ResponseEntity<>(new ResponseApi(false, exception),
                   HttpStatus.BAD_REQUEST);
       }
    }
}

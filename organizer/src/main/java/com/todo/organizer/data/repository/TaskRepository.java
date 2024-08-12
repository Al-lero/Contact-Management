package com.todo.organizer.data.repository;

import com.todo.organizer.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task, String> {

    Task findByName(String taskName);
}

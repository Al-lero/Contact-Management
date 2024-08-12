package com.todo.organizer.data.repository;

import com.todo.organizer.data.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

    Project findByName(String name);
}

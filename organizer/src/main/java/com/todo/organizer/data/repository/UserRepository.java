package com.todo.organizer.data.repository;

import com.todo.organizer.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String > {


    User findByEmail(String email);
}

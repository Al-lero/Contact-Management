package com.todo.organizer.web;

import com.todo.organizer.data.models.User;
import com.todo.organizer.dto.request.CreateUserRequest;
import com.todo.organizer.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/create")
//    public ResponseEntity <User> createUser(@RequestBody CreateUserRequest createUserRequest){
//        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
//    }
//}
}

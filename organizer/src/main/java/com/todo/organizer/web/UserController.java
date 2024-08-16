package com.todo.organizer.web;

import com.todo.organizer.data.models.User;
import com.todo.organizer.data.repository.UserRepository;
import com.todo.organizer.dto.request.*;
import com.todo.organizer.dto.response.*;
import com.todo.organizer.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForThaiBuddhistDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/create")
    public ResponseEntity <?> createUser(@RequestBody CreateUserRequest createUserRequest){
      try{
          CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
          return new ResponseEntity<>(createUserResponse,HttpStatus.CREATED);
      }
      catch(Exception e){
          return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest){
        try{
            DeleteUserResponse deleteUser = userService.deleteUser(deleteUserRequest);
            return new ResponseEntity<>(deleteUser,HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findUser")
    public ResponseEntity<?> findUser(@RequestBody FindUserRequest findUserRequest){
        try {
            FindUserResponse findUser = userService.findUser(findUserRequest);
            return new ResponseEntity<>(findUser, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        try {
            UpdateUserResponse updatedUser = userService.updateUser(updateUserRequest);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("displayAllUser")
    public ResponseEntity<?> displayAllUser(){
        try {
            List<User> findAll = userService.findAllUsers();
            return new ResponseEntity<>(new ResponseApi(true, findAll),HttpStatus.OK );
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResponseApi(false, exception),HttpStatus.BAD_REQUEST);
        }
    }

}


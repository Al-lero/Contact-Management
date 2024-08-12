package com.todo.organizer.services.user;

import com.todo.organizer.dto.request.CreateUserRequest;
import com.todo.organizer.dto.request.DeleteUserRequest;
import com.todo.organizer.dto.request.FindUserRequest;
import com.todo.organizer.dto.response.CreateUserResponse;
import com.todo.organizer.dto.response.DeleteUserResponse;
import com.todo.organizer.dto.response.FindUserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

    DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest);

    FindUserResponse findUser(FindUserRequest findUserRequest);
}

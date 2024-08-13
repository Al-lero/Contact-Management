package com.todo.organizer.services.user;

import com.todo.organizer.data.models.User;
import com.todo.organizer.data.repository.UserRepository;
import com.todo.organizer.dto.request.CreateUserRequest;
import com.todo.organizer.dto.request.DeleteUserRequest;
import com.todo.organizer.dto.request.FindUserRequest;
import com.todo.organizer.dto.request.UpdateUserRequest;
import com.todo.organizer.dto.response.CreateUserResponse;
import com.todo.organizer.dto.response.DeleteUserResponse;
import com.todo.organizer.dto.response.FindUserResponse;
import com.todo.organizer.dto.response.UpdateUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        if(findByEmail(createUserRequest.getEmail())){
            throw new RuntimeException("No User Found");
        }
            User user = new User();
        user.setName(createUserRequest.getName());
        user.setEmail(createUserRequest.getEmail());
        userRepository.save(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("User created Successfully");
        response.setId(user.getId());
        return response;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest) {
        if(findById(deleteUserRequest.getId()).isEmpty()){
            throw new RuntimeException("No User Found");
        }
        User user = findById(deleteUserRequest.getId()).get();
        userRepository.delete(user);

       DeleteUserResponse response = new DeleteUserResponse();
       response.setMessage("User deleted Successfully");
       return response;

    }

    @Override
    public FindUserResponse findUser(FindUserRequest findUserRequest) {

        if (findById(findUserRequest.getId()).isEmpty()) {
            throw new RuntimeException("User Not Found");
        }

        User user = findById(findUserRequest.getId()).get();
        userRepository.findAll();

        FindUserResponse response = new FindUserResponse();
        response.setMessage("User Found");
        return response;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }


    private boolean findByEmail(String email){
        return userRepository.findByEmail(email)!=null;
    }

    private Optional<User> findById(String id){
        return userRepository.findById(id);
    }

}

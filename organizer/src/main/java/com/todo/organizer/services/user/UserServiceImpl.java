package com.todo.organizer.services.user;

import com.todo.organizer.data.models.User;
import com.todo.organizer.data.repository.UserRepository;
import com.todo.organizer.dto.request.CreateUserRequest;
import com.todo.organizer.dto.request.DeleteUserRequest;
import com.todo.organizer.dto.request.FindUserRequest;
import com.todo.organizer.dto.response.CreateUserResponse;
import com.todo.organizer.dto.response.DeleteUserResponse;
import com.todo.organizer.dto.response.FindUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        if(findByEmail(createUserRequest.getEmail())){
            throw new RuntimeException("No User Found");
        }
            User user = new User();
        user.setName(createUserRequest.getName());
        user.setEmail(createUserRequest.getEmail());
        User save = userRepository.save(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("User created Successfully");
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


    private boolean findByEmail(String email){
        return userRepository.findByEmail(email)!=null;
    }

    private Optional<User> findById(String id){
        return userRepository.findById(id);
    }

}

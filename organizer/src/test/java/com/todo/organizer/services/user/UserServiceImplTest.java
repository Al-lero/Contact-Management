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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;



    @BeforeEach
    void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanBeCreated(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Alero");
        createUserRequest.setEmail("efs");
        CreateUserResponse response = userService.createUser(createUserRequest);
        User user = userRepository.findByEmail("efs");
        assertNotNull(user);
        assertEquals(1,userRepository.count());

    }

    @Test
    public void testThatUserCanBeFindById(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Alero");
        createUserRequest.setEmail("efs");
        CreateUserResponse response = userService.createUser(createUserRequest);
        FindUserRequest findUserRequest = new FindUserRequest();
        findUserRequest.setId(response.getId());
        FindUserResponse response1 = userService.findUser(findUserRequest);
        assertThat(response1.getMessage().contains("User Found"));

    }

    @Test
    public void testThatUserCanBeDeletedByEmail(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Alero");
        createUserRequest.setEmail("efs");
        CreateUserResponse response = userService.createUser(createUserRequest);
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setId(response.getId());
        DeleteUserResponse response1 = userService.deleteUser(deleteUserRequest);
        assertThat(response1.getMessage().contains("User Deleted"));

    }

    @Test
    public void testThatUserCanBeUpdated(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Alero");
        createUserRequest.setEmail("efs");
        CreateUserResponse response1 = userService.createUser(createUserRequest);
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setId(response1.getId());
        UpdateUserResponse response = userService.updateUser(updateUserRequest);
        assertThat(response.getMessage().contains("Updated Successfully"));
    }


}
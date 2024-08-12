package com.todo.organizer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CreateUserRequest {

    private String name;
    private String email;

}

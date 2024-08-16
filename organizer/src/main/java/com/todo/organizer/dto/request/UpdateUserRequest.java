package com.todo.organizer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private String id;
    private String email;
    private String name;


}

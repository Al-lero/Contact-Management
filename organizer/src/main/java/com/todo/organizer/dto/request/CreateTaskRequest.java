package com.todo.organizer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {
    private String name;
    private String description;
    private String status;
    private String user;
}

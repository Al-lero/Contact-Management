package com.todo.organizer.dto.request;

import com.todo.organizer.Enums.Status;
import lombok.Data;

@Data
public class UpdateTaskRequest {
    private String newName;
    private String name;;
    private String user;
    private Status status;
    private String description;
}

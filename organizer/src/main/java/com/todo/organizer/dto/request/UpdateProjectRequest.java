package com.todo.organizer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProjectRequest {
    private String id;
    private String name;
    private String description;
}

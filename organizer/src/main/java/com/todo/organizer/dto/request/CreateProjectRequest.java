package com.todo.organizer.dto.request;

import com.todo.organizer.data.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CreateProjectRequest {
    private String name;
    private String description;
    private String dateCreated;
    private List<Task> tasks = new ArrayList<>();
}

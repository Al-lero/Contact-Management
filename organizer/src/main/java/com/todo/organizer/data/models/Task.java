package com.todo.organizer.data.models;

import com.todo.organizer.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String id;
    private String user;
    private String name;
    private String dateCreated;
    private Status status;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();


}

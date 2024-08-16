package com.todo.organizer.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Project {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Task> tasks = new ArrayList<>();

}

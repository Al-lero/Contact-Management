package com.todo.organizer.services.projects;

import com.todo.organizer.dto.request.CreateProjectRequest;
import com.todo.organizer.dto.request.DeleteProjectRequest;
import com.todo.organizer.dto.request.FindProjectRequest;
import com.todo.organizer.dto.response.CreateProjectResponse;
import com.todo.organizer.dto.response.DeleteProjectResponse;
import com.todo.organizer.dto.response.FindProjectResponse;

public interface ProjectService {

    CreateProjectResponse createProject(CreateProjectRequest createProjectRequest);

    FindProjectResponse findProject(FindProjectRequest findProjectRequest);

    DeleteProjectResponse deleteProject(DeleteProjectRequest deleteProjectRequest);
}

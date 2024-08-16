package com.todo.organizer.services.projects;

import com.todo.organizer.data.models.Project;
import com.todo.organizer.dto.request.CreateProjectRequest;
import com.todo.organizer.dto.request.DeleteProjectRequest;
import com.todo.organizer.dto.request.FindProjectRequest;
import com.todo.organizer.dto.request.UpdateProjectRequest;
import com.todo.organizer.dto.response.CreateProjectResponse;
import com.todo.organizer.dto.response.DeleteProjectResponse;
import com.todo.organizer.dto.response.FindProjectResponse;
import com.todo.organizer.dto.response.UpdateProjectResponse;

import java.util.List;

public interface ProjectService {

    CreateProjectResponse createProject(CreateProjectRequest createProjectRequest);

    FindProjectResponse findProject(FindProjectRequest findProjectRequest);

    DeleteProjectResponse deleteProject(DeleteProjectRequest deleteProjectRequest);

    UpdateProjectResponse updateProject(UpdateProjectRequest request);

    List<Project> findAllProjects();
}

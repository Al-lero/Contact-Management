package com.todo.organizer.services.projects;

import com.todo.organizer.data.models.Project;
import com.todo.organizer.data.repository.ProjectRepository;
import com.todo.organizer.dto.request.CreateProjectRequest;
import com.todo.organizer.dto.request.DeleteProjectRequest;
import com.todo.organizer.dto.request.FindProjectRequest;
import com.todo.organizer.dto.response.CreateProjectResponse;
import com.todo.organizer.dto.response.DeleteProjectResponse;
import com.todo.organizer.dto.response.FindProjectResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;


    @Override
    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest) {
        if(projectExist(createProjectRequest.getName())){
            throw new RuntimeException("Project already Exist");
    }

        Project project = new Project();
        project.setCreatedAt(LocalDateTime.parse(createProjectRequest.getDateCreated()));
        project.setName(createProjectRequest.getName());
        project.setDescription(createProjectRequest.getDescription());
        Project save = projectRepository.save(project);

        CreateProjectResponse response = new CreateProjectResponse();
        response.setMessage("Project Created");
        return response;


    }

    private boolean projectExist(String name) {
            return projectRepository.findByName(name)!=null;
    }

    @Override
    public FindProjectResponse findProject(FindProjectRequest findProjectRequest) {
        if(findById(findProjectRequest.getId()).isEmpty()){
            throw new RuntimeException("Project Not Found");
        }

        Project project = findById(findProjectRequest.getId()).get();
        projectRepository.deleteAll();

        FindProjectResponse response = new FindProjectResponse();
        response.setMessage("Project Found");
        return response;
    }

    @Override
    public DeleteProjectResponse deleteProject(DeleteProjectRequest deleteProjectRequest) {
        if(findById(deleteProjectRequest.getId()).isEmpty()){
            throw new RuntimeException("No Project");
        }

        Project project = findById(deleteProjectRequest.getId()).get();
        projectRepository.delete(project);

        DeleteProjectResponse response = new DeleteProjectResponse();
        response.setMessage("Project deleted Successfully");
        return response;
    }

    private Optional<Project> findById(String id) {
            return projectRepository.findById(id);
        }
    }






package com.todo.organizer.services.projects;

import com.todo.organizer.data.models.Project;
import com.todo.organizer.data.repository.ProjectRepository;
import com.todo.organizer.dto.request.CreateProjectRequest;
import com.todo.organizer.dto.request.DeleteProjectRequest;
import com.todo.organizer.dto.request.FindProjectRequest;
import com.todo.organizer.dto.request.UpdateProjectRequest;
import com.todo.organizer.dto.response.CreateProjectResponse;
import com.todo.organizer.dto.response.DeleteProjectResponse;
import com.todo.organizer.dto.response.FindProjectResponse;
import com.todo.organizer.dto.response.UpdateProjectResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest) {
        if(projectExist(createProjectRequest.getName())){
            throw new RuntimeException("Project already Exist");
    }

        Project project = new Project();
        project.setCreatedAt(LocalDateTime.now());
        project.setName(createProjectRequest.getName());
        project.setDescription(createProjectRequest.getDescription());
        Project save = projectRepository.save(project);

        CreateProjectResponse response = new CreateProjectResponse();
        response.setId(project.getId());
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
            throw new RuntimeException("Project deleted");
        }

        Project project = findById(deleteProjectRequest.getId()).get();
        projectRepository.delete(project);

        DeleteProjectResponse response = new DeleteProjectResponse();
        response.setMessage("Project deleted Successfully");
        return response;
    }

    @Override
    public UpdateProjectResponse updateProject(UpdateProjectRequest request) {
        Project project = findById(request.getId())
                .orElseThrow(()-> new RuntimeException("project not found"));
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        projectRepository.save(project);
        UpdateProjectResponse response = new UpdateProjectResponse();
        response.setMessage("Successful");
        return response;
    }
    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    private Optional<Project> findById(String id) {
            return projectRepository.findById(id);
        }
    }






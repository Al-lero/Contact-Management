package com.todo.organizer.web;

import com.todo.organizer.data.models.Project;
import com.todo.organizer.data.repository.ProjectRepository;
import com.todo.organizer.dto.request.*;
import com.todo.organizer.dto.response.*;
import com.todo.organizer.services.projects.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;


    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody CreateProjectRequest createProjectRequest){
        try{
            CreateProjectResponse createProjectResponse = projectService.createProject(createProjectRequest);
            return new ResponseEntity<>(createProjectResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteProject(@RequestBody DeleteProjectRequest deleteProjectRequest){
        try{
            DeleteProjectResponse deleteProject = projectService.deleteProject(deleteProjectRequest);
            return new ResponseEntity<>(deleteProject,HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findProject")
    public ResponseEntity<?> findProject(@RequestBody FindProjectRequest findProjectRequest){
        try {
            FindProjectResponse findProject = projectService.findProject(findProjectRequest);
            return new ResponseEntity<>(findProject, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("updateProject")
    public ResponseEntity<?> updateProject(@RequestBody UpdateProjectRequest updateProjectRequest){
       try {
           UpdateProjectResponse updateProject = projectService.updateProject(updateProjectRequest);
           return new ResponseEntity<>(updateProject, HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping
    public ResponseEntity<?> displayAllProjects(){
        try {
            List<Project> findAllProjects = projectService.findAllProjects();
            return new ResponseEntity<>(new ResponseApi(true, findAllProjects ),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ResponseApi(false, exception),
                    HttpStatus.BAD_REQUEST);
        }
    }
}

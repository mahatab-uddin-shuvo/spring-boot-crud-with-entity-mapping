package com.example.employeemicroservice.controller;

import com.example.employeemicroservice.entity.Project;
import com.example.employeemicroservice.exception.NotFoundException;
import com.example.employeemicroservice.exception.SQLIntegrityException;
import com.example.employeemicroservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project project1 = this.projectService.addProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getProjects", "/{projectId}"})
    public List<Project> getProjects(@PathVariable(required = false) Long projectId) {
        return projectService.getProjectDetails(projectId);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId)  throws  NotFoundException,SQLIntegrityException {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.OK);
    }
}

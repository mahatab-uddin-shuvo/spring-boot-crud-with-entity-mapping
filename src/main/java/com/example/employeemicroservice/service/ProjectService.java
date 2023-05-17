package com.example.employeemicroservice.service;


import com.example.employeemicroservice.entity.Project;
import com.example.employeemicroservice.exception.SQLIntegrityException;

import java.util.List;

public interface ProjectService {
    Project addProject(Project project);
    List<Project> getProjectDetails(Long projectId);
    void deleteProject(Long projectId) throws SQLIntegrityException;

}

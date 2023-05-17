package com.example.employeemicroservice.service.impl;

import com.example.employeemicroservice.entity.Project;
import com.example.employeemicroservice.exception.NotFoundException;
import com.example.employeemicroservice.exception.SQLIntegrityException;
import com.example.employeemicroservice.repository.ProjectRepository;
import com.example.employeemicroservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getProjectDetails(Long projectId) {
        if (null != projectId) {
            return projectRepository.findAllByProjectId(projectId);
        } else {
            return projectRepository.findAll();
        }
    }

    @Override
    public void deleteProject(Long projectId) throws SQLIntegrityException {
        Optional<Project> projects = projectRepository.findById(projectId);
        if(projects.isEmpty()){
            throw new NotFoundException("Project Not Found With id : " + projectId);
        }
        try{
            projectRepository.deleteById(projectId);
        }catch (Exception e){
            throw new SQLIntegrityException("The project is not delete because, this project already assign to person");
        }
    }
}

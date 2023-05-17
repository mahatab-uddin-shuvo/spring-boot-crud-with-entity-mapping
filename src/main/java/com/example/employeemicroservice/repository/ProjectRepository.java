package com.example.employeemicroservice.repository;

import com.example.employeemicroservice.entity.Person;
import com.example.employeemicroservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project ,Long> {
    List<Project> findAllByProjectId(Long projectId);

}

package com.example.employeemicroservice.service.impl;

import com.example.employeemicroservice.entity.Person;
import com.example.employeemicroservice.entity.Project;
import com.example.employeemicroservice.exception.NotFoundException;
import com.example.employeemicroservice.repository.PersonRepository;
import com.example.employeemicroservice.repository.ProjectRepository;
import com.example.employeemicroservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersonDetails(Long personId) {
        if (null != personId ) {
            return personRepository.findAllByPersonId(personId);
        } else {
            return personRepository.findAll();
        }
    }

    @Override
    public void deletePerson(long personId) {
        try {
            personRepository.deleteById(personId);
        } catch (Exception e) {
            throw new NotFoundException("Employee Not Found With id : " + personId);
        }
    }

    @Override
    public Person assignProjectToPerson(Long personId, Long projectId) {
        Set<Project> projectSet = null;
        Person person = personRepository.findById(personId).get();
        Project project = projectRepository.findById(projectId).get();
        projectSet = person.getAssignProjects();
        projectSet.add(project);
        person.setAssignProjects(projectSet);
        return personRepository.save(person);
    }

    @Override
    public Person removeProjectToPerson(Long personId, Long projectId) {
        Set<Project> projectRemove = null;
        Person person = personRepository.findById(personId).get();
        Project project = projectRepository.findById(projectId).get();
        projectRemove = person.getAssignProjects();
        projectRemove.remove(project);
        person.setAssignProjects(projectRemove);
        return personRepository.save(person);
    }
}

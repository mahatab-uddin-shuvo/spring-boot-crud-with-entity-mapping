package com.example.employeemicroservice.service;

import com.example.employeemicroservice.entity.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);

    List<Person> getPersonDetails(Long personId);

    void deletePerson(long personId);

    Person assignProjectToPerson(Long personId, Long projectId);

    Person removeProjectToPerson(Long personId, Long projectId);

}

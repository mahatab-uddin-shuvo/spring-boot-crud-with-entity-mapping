package com.example.employeemicroservice.repository;

import com.example.employeemicroservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findAllByPersonId(Long personId);

}

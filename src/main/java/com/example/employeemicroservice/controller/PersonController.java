package com.example.employeemicroservice.controller;

import com.example.employeemicroservice.entity.Person;
import com.example.employeemicroservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        Person person1 = this.personService.addPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

//        @GetMapping("/getPerson/{personId}")
    @GetMapping(value = {"/getPersons", "/{personId}"})
    public List<Person> getPerson(@PathVariable(required = false) Long personId){
        return personService.getPersonDetails(personId);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable long personId) {
        this.personService.deletePerson(personId);
        return new ResponseEntity<>("Deleted SuccessFully", HttpStatus.OK);
    }

    @PutMapping("/{personId}/project/{projectId}")
    public Person assignProjectToPerson(
            @PathVariable Long personId,
            @PathVariable Long projectId
    ) {
        return personService.assignProjectToPerson(personId, projectId);
    }

    @PutMapping("/remove/{personId}/project/{projectId}")
    public Person removeProjectToPerson(
            @PathVariable Long personId,
            @PathVariable Long projectId
    ) {
        return personService.removeProjectToPerson(personId, projectId);
    }

    @GetMapping(value = { "/api/employeeswithrequiredfalse", "/api/employeeswithrequiredfalse/{id}" })
    @ResponseBody
    public String getEmployeesByIdWithRequiredFalse(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }
}

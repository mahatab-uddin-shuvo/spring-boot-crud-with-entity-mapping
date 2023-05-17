package com.example.employeemicroservice.controller;

import com.example.employeemicroservice.entity.Employee;
import com.example.employeemicroservice.exception.IllegalException;
import com.example.employeemicroservice.exception.NotFoundException;
import com.example.employeemicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmplyee(@Valid @RequestBody Employee employee) {
        Employee employees = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Employee>> getAllEmployee(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
    ) throws IllegalException {

//        @RequestParam(defaultValue = "id") String sortBy
        List<Employee> employeeAll = this.employeeService.getAllEmployee(pageNumber, pageSize);
        return new ResponseEntity<>(employeeAll, HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) throws NotFoundException {
        Employee employee = this.employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        Employee updateEmployee = this.employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) throws NotFoundException {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted Successfully with id: " + id, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(employeeService.searchEmployee(query));
    }
}

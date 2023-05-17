package com.example.employeemicroservice.service;

import com.example.employeemicroservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee(int pageNumber, int pageSize);

    Employee getEmployee(long id);

    Employee updateEmployee(long id,Employee employee);

    void deleteEmployee(long id);

    List<Employee> searchEmployee(String query);
}

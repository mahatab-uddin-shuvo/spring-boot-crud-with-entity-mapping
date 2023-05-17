package com.example.employeemicroservice.service.impl;

import com.example.employeemicroservice.entity.Employee;
import com.example.employeemicroservice.exception.IllegalException;
import com.example.employeemicroservice.exception.NotFoundException;
import com.example.employeemicroservice.repository.EmployeeRepository;
import com.example.employeemicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }


    @Override
    public List<Employee> getAllEmployee(int pageNumber, int pageSize) {

        if (pageSize > 0) {
            if (pageNumber >= 0) {
                Pageable page = PageRequest.of(pageNumber, pageSize);

                Page<Employee> pageEmp = this.employeeRepository.findAll(page);
                //        return pageEmp.getContent();
                List<Employee> allEmp = pageEmp.getContent();

                return allEmp;
            } else {
                throw new IllegalException("Page Number Must be grater or equal then 0 : " + pageNumber);
            }
        } else {
            throw new IllegalException("Page Size Must be grater then 0 : " + pageSize);
        }


    }

    @Override
    public Employee getEmployee(long id) {
        try {
            return employeeRepository.findById(id).get();
        } catch (Exception e) {
            throw new NotFoundException("Employee Not Found With id : " + id);
        }
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee emp = employeeRepository.findById(id).get();
        if (employee.getName() != null) emp.setName(employee.getName());
        if (employee.getEmailId() != null) emp.setEmailId(employee.getEmailId());
        if (employee.getAge() != 0) emp.setAge(employee.getAge());
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Employee Not Found With id : " + id);
        }
    }

    @Override
    public List<Employee> searchEmployee(String query) {
        List<Employee> employee = employeeRepository.searchEmployeesSQL(query);
        return employee;
    }
}

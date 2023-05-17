package com.example.employeemicroservice.repository;

import com.example.employeemicroservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Modifying
    @Query("SELECT emp FROM Employee emp WHERE " +
            "emp.name LIKE CONCAT('%',:query, '%')" +
            "Or emp.emailId LIKE CONCAT('%', :query, '%')")
//            "OR CONCAT(emp.age, '') like CONCAT('%', :query, '%')")
//    @Query("Select emp from Employee emp " +
//            "where emp.name like %:query%" +
//            "OR emp.emailId like %:query%"+
//            "OR CONCAT(emp.age, '') like %:query%"
//    )


    List<Employee> searchEmployeesSQL(String query);
}

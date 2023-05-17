package com.example.employeemicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_sequence"
    )
    private long id;
    @NotNull(message = "name Should not empty")
    private String name;
    @NotNull(message = "email Should not empty")
    @Email(regexp = ".*")
    private String emailId;

    @NotNull(message = "age Should not empty")
    @Min(value = 18)
    @Max(value = 70)
    private int age;

    //address_add_id
//    @OneToOne(cascade = CascadeType.ALL)
//    @Valid
//    @JoinColumn(name = "fk_add_id")
//    @NotNull(message = "address Should not empty")
//    private Address address ;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_id" ,referencedColumnName = "id")
    private List<Address> address;

}

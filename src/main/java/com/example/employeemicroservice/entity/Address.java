package com.example.employeemicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "add_id")
    private long addressId;

    @NotNull(message = "city Should not empty")
    private String city;

    @NotNull(message = "addressType Should not empty")
    private String addressType;

//    @OneToOne(mappedBy = "address")
//    private Employee employee;
}

package com.example.employeemicroservice.repository;

import com.example.employeemicroservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}

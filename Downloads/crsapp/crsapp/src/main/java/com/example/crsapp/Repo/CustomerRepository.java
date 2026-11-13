package com.example.crsapp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crsapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query example:
    Optional<Customer> findByEmail(String email);
}
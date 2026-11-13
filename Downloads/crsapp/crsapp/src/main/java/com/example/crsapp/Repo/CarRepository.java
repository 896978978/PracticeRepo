package com.example.crsapp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crsapp.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Custom query example:
    List<Car> findByAvailableTrue();
    List<Car> findByBrand(String brand);
}
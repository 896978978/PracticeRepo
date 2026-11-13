package com.example.crsapp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crsapp.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Custom query example:
    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findByCarId(Long carId);
}
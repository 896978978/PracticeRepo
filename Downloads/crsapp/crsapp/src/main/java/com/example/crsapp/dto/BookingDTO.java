package com.example.crsapp.dto;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookingDTO{
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalCost;

    private Long carId;       // reference instead of full Car
    private Long customerId;  // reference instead of full Customer
    private DamageReportDTO damageReport; // nested DTO
}
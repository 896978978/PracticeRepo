package com.example.crsapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Double pricePerDay;
    private Boolean available;
}
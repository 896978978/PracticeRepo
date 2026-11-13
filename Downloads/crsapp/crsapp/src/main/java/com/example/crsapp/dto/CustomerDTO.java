package com.example.crsapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String driverLicenseNumber;
}
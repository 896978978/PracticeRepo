package com.example.crsapp.dto;



import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DamageReportDTO {
    private Long id;
    private String description;
    private Double estimatedCost;
}
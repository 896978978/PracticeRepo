package com.example.crsapp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crsapp.model.DamageReport;

public interface DamageReportRepository extends JpaRepository<DamageReport, Long> {
    // Custom query example:
    List<DamageReport> findByEstimatedCostGreaterThan(Double cost);
}
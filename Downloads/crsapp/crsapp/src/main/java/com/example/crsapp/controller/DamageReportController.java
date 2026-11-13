package com.example.crsapp.controller;

import org.springframework.web.bind.annotation.*;
import com.example.crsapp.dto.DamageReportDTO;
import com.example.crsapp.service.DamageReportService;

import java.util.List;

@RestController
@RequestMapping("/api/damageReports")
public class DamageReportController {
    private final DamageReportService damageReportService;

    public DamageReportController(DamageReportService damageReportService) {
        this.damageReportService = damageReportService;
    }

    // Get all damage reports
    @GetMapping
    public List<DamageReportDTO> getAllReports() {
        return damageReportService.getAllReports();
    }

    // Get damage report by ID
    @GetMapping("/{id}")
    public DamageReportDTO getReportById(@PathVariable Long id) {
        return damageReportService.getReportById(id);
    }

    // Create a new damage report
    @PostMapping
    public DamageReportDTO createReport(@RequestBody DamageReportDTO reportDTO) {
        return damageReportService.saveReport(reportDTO);
    }

    // Delete damage report by ID
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        damageReportService.deleteReport(id);
    }

    // Get reports above a certain estimated cost
    @GetMapping("/cost/{cost}")
    public List<DamageReportDTO> getReportsAboveCost(@PathVariable Double cost) {
        return damageReportService.getReportsAboveCost(cost);
    }
}
package com.example.crsapp.service;

import com.example.crsapp.Repo.DamageReportRepository;
import com.example.crsapp.dto.DamageReportDTO;
import com.example.crsapp.exception.DamageReportNotFoundException;
import com.example.crsapp.Mapper.DamageReportMapper;
import com.example.crsapp.model.DamageReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageReportService {
    private final DamageReportRepository damageReportRepository;

    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    public List<DamageReportDTO> getAllReports() {
        List<DamageReport> reports = damageReportRepository.findAll();
        return DamageReportMapper.toDTOList(reports);
    }

    public DamageReportDTO getReportById(Long id) {
        DamageReport report = damageReportRepository.findById(id)
                .orElseThrow(() -> new DamageReportNotFoundException("Damage report with ID " + id + " not found"));
        return DamageReportMapper.toDTO(report);
    }

    public DamageReportDTO saveReport(DamageReportDTO reportDTO) {
        DamageReport report = DamageReportMapper.toEntity(reportDTO);
        DamageReport saved = damageReportRepository.save(report);
        return DamageReportMapper.toDTO(saved);
    }

    public void deleteReport(Long id) {
        if (!damageReportRepository.existsById(id)) {
            throw new DamageReportNotFoundException("Damage report with ID " + id + " not found");
        }
        damageReportRepository.deleteById(id);
    }

    public List<DamageReportDTO> getReportsAboveCost(Double cost) {
        List<DamageReport> reports = damageReportRepository.findByEstimatedCostGreaterThan(cost);
        return DamageReportMapper.toDTOList(reports);
    }
}
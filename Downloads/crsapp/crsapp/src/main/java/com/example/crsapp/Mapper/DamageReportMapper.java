package com.example.crsapp.Mapper;


import com.example.crsapp.dto.DamageReportDTO;
import com.example.crsapp.model.DamageReport;

import java.util.ArrayList;
import java.util.List;

public class DamageReportMapper {

    public static DamageReportDTO toDTO(DamageReport report) {
        if (report == null) return null;

        DamageReportDTO dto = new DamageReportDTO();
        dto.setId(report.getId());
        dto.setDescription(report.getDescription());
        dto.setEstimatedCost(report.getEstimatedCost());
        return dto;
    }

    public static DamageReport toEntity(DamageReportDTO dto) {
        if (dto == null) return null;

        DamageReport report = new DamageReport();
        report.setId(dto.getId());
        report.setDescription(dto.getDescription());
        report.setEstimatedCost(dto.getEstimatedCost());
        return report;
    }

    public static List<DamageReportDTO> toDTOList(List<DamageReport> reports) {
        List<DamageReportDTO> dtos = new ArrayList<>();
        for (DamageReport report : reports) {
            dtos.add(toDTO(report));
        }
        return dtos;
    }
}
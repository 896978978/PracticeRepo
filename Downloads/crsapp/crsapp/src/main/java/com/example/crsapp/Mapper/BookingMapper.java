package com.example.crsapp.Mapper;


import com.example.crsapp.dto.BookingDTO;
import com.example.crsapp.dto.DamageReportDTO;
import com.example.crsapp.model.Booking;
import com.example.crsapp.model.DamageReport;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) return null;

        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setStartDate(booking.getStartDate());
        dto.setEndDate(booking.getEndDate());
        dto.setTotalCost(booking.getTotalCost());

        // Many-to-one: just reference IDs
        if (booking.getCar() != null) {
            dto.setCarId(booking.getCar().getId());
        }
        if (booking.getCustomer() != null) {
            dto.setCustomerId(booking.getCustomer().getId());
        }

        // One-to-one: embed DamageReportDTO
        DamageReport dr = booking.getDamageReport();
        if (dr != null) {
            DamageReportDTO drDto = new DamageReportDTO();
            drDto.setId(dr.getId());
            drDto.setDescription(dr.getDescription());
            drDto.setEstimatedCost(dr.getEstimatedCost());
            dto.setDamageReport(drDto);
        }

        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) return null;

        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setTotalCost(dto.getTotalCost());
        // Car and Customer are set in service layer via repositories
        return booking;
    }

    public static List<BookingDTO> toDTOList(List<Booking> bookings) {
        List<BookingDTO> dtos = new ArrayList<>();
        for (Booking booking : bookings) {
            dtos.add(toDTO(booking));
        }
        return dtos;
    }
}
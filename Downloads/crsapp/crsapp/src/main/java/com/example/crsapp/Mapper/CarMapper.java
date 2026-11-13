package com.example.crsapp.Mapper;



import com.example.crsapp.dto.CarDTO;
import com.example.crsapp.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {

    public static CarDTO toDTO(Car car) {
        if (car == null) return null;

        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setRegistrationNumber(car.getRegistrationNumber());
        dto.setPricePerDay(car.getPricePerDay());
        dto.setAvailable(car.getAvailable());
        return dto;
    }

    public static Car toEntity(CarDTO dto) {
        if (dto == null) return null;

        Car car = new Car();
        car.setId(dto.getId());
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setRegistrationNumber(dto.getRegistrationNumber());
        car.setPricePerDay(dto.getPricePerDay());
        car.setAvailable(dto.getAvailable());
        return car;
    }

    public static List<CarDTO> toDTOList(List<Car> cars) {
        List<CarDTO> dtos = new ArrayList<>();
        for (Car car : cars) {
            dtos.add(toDTO(car));
        }
        return dtos;
    }
}
package com.example.crsapp.controller;

import com.example.crsapp.dto.CarDTO;
import com.example.crsapp.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Get all cars
    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    // Get car by ID
    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    // Save a new car
    @PostMapping
    public CarDTO saveCar(@RequestBody CarDTO carDTO) {
        return carService.saveCar(carDTO);
    }

    // Delete car by ID
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    // Get available cars
    @GetMapping("/available")
    public List<CarDTO> getAvailableCars() {
        return carService.getAvailableCars();
    }
}
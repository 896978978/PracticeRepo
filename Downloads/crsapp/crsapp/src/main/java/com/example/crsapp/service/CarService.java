package com.example.crsapp.service;

import com.example.crsapp.Repo.CarRepository;
import com.example.crsapp.dto.CarDTO;
import com.example.crsapp.exception.CarNotFoundException;
import com.example.crsapp.Mapper.CarMapper;
import com.example.crsapp.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return CarMapper.toDTOList(cars);
    }

    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car with ID " + id + " not found"));
        return CarMapper.toDTO(car);
    }

    public CarDTO saveCar(CarDTO carDTO) {
        Car car = CarMapper.toEntity(carDTO);
        Car saved = carRepository.save(car);
        return CarMapper.toDTO(saved);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new CarNotFoundException("Car with ID " + id + " not found");
        }
        carRepository.deleteById(id);
    }

    public List<CarDTO> getAvailableCars() {
        List<Car> cars = carRepository.findByAvailableTrue();
        return CarMapper.toDTOList(cars);
    }
}
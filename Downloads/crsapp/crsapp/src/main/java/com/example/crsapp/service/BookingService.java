
package com.example.crsapp.service;

import com.example.crsapp.Repo.BookingRepository;
import com.example.crsapp.Repo.CarRepository;
import com.example.crsapp.Repo.CustomerRepository;
import com.example.crsapp.dto.BookingDTO;
import com.example.crsapp.exception.BookingNotFoundException;
import com.example.crsapp.exception.CarNotFoundException;
import com.example.crsapp.exception.CustomerNotFoundException;
import com.example.crsapp.Mapper.BookingMapper;
import com.example.crsapp.model.Booking;
import com.example.crsapp.model.Car;
import com.example.crsapp.model.Customer;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public BookingService(BookingRepository bookingRepository,
                          CarRepository carRepository,
                          CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return BookingMapper.toDTOList(bookings);
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with ID " + id + " not found"));
        return BookingMapper.toDTO(booking);
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = BookingMapper.toEntity(bookingDTO);

        Car car = carRepository.findById(bookingDTO.getCarId())
                .orElseThrow(() -> new CarNotFoundException("Car with ID " + bookingDTO.getCarId() + " not found"));

        if (!car.getAvailable()) {
            throw new IllegalStateException("Car is not available for booking");
        }

        Customer customer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + bookingDTO.getCustomerId() + " not found"));

        long days = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
        booking.setTotalCost(days * car.getPricePerDay());

        booking.setCar(car);
        booking.setCustomer(customer);

        car.setAvailable(false);
        carRepository.save(car);

        Booking saved = bookingRepository.save(booking);
        return BookingMapper.toDTO(saved);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking with ID " + id + " not found");
        }
        bookingRepository.deleteById(id);
    }

    public List<BookingDTO> getBookingsByCustomer(Long customerId) {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
        return BookingMapper.toDTOList(bookings);
    }
}
package com.example.crsapp.model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "bookings")
@Getter @Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalCost;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference // ✅ prevents infinite loop when serializing Car → Booking → Car
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference // ✅ prevents infinite loop when serializing Customer → Booking → Customer
    private Customer customer;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonManagedReference // ✅ forward side of one-to-one
    private DamageReport damageReport;
}
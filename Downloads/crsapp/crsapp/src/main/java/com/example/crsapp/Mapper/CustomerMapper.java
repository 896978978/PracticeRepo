package com.example.crsapp.Mapper;


import com.example.crsapp.dto.CustomerDTO;
import com.example.crsapp.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;

        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setDriverLicenseNumber(customer.getDriverLicenseNumber());
        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        return customer;
    }

    public static List<CustomerDTO> toDTOList(List<Customer> customers) {
        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer customer : customers) {
            dtos.add(toDTO(customer));
        }
        return dtos;
    }
}
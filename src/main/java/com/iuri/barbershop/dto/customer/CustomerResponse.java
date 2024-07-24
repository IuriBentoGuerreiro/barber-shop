package com.iuri.barbershop.dto.customer;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerResponse {

    private Integer id;
    private String name;
    private String phoneNumber;
    private List<Appointment> appointments;

    public static CustomerResponse convert(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .appointments(customer.getAppointments())
                .build();
    }
}

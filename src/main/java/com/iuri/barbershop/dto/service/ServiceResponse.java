package com.iuri.barbershop.dto.service;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Work;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ServiceResponse {

    private Integer id;
    private String name;
    private Double price;
    private List<Appointment> appointments;

    public static ServiceResponse convert(Work service){
        return ServiceResponse.builder()
                .name(service.getName())
                .price(service.getPrice())
                .appointments(service.getAppointments())
                .build();
    }
}

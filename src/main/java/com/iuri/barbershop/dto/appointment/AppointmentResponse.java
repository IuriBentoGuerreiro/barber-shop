package com.iuri.barbershop.dto.appointment;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Barber;
import com.iuri.barbershop.model.Customer;
import com.iuri.barbershop.model.Work;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentResponse {

    private Integer id;
    private LocalDateTime appointmentTime;
    private Barber barber;
    private Customer customer;
    private Work service;

    public static AppointmentResponse convert(Appointment appointment){
        return AppointmentResponse.builder()
                .appointmentTime(appointment.getAppointmentTime())
                .barber(appointment.getBarber())
                .customer(appointment.getCustomer())
                .service(appointment.getService())
                .build();
    }
}

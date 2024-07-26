package com.iuri.barbershop.dto.appointment;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Barber;
import com.iuri.barbershop.model.Customer;
import com.iuri.barbershop.model.Procedure;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AppointmentResponse {

    private Integer id;
    private LocalDateTime appointmentTime;
    private Barber barber;
    private Customer customer;
    private List<Procedure> procedures;

    public static AppointmentResponse convert(Appointment appointment){
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .appointmentTime(appointment.getAppointmentTime())
                .barber(appointment.getBarber())
                .customer(appointment.getCustomer())
                .procedures(appointment.getProcedures())
                .build();
    }
}

package com.iuri.barbershop.dto.appointment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {

    private LocalDateTime appointmentTime;
    private Integer barberId;
    private Integer customerId;
    private Integer procedureId;
}

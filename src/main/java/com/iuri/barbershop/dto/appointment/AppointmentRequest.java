package com.iuri.barbershop.dto.appointment;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppointmentRequest {

    private LocalDateTime appointmentTime;
    private Integer barberId;
    private Integer customerId;
    private List<Integer> proceduresId;
}

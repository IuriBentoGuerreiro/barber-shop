package com.iuri.barbershop.model;

import com.iuri.barbershop.dto.appointment.AppointmentRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Work service;

    public static Appointment convert(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .appointmentTime(appointmentRequest.getAppointmentTime())
                .barber(new Barber(appointmentRequest.getBarberId()))
                .customer(new Customer(appointmentRequest.getCustomerId()))
                .service(new Work(appointmentRequest.getServiceId()))
                .build();
    }
}

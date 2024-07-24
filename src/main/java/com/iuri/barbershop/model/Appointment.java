package com.iuri.barbershop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iuri.barbershop.dto.appointment.AppointmentRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    @JsonBackReference
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "appointment")
    @JsonBackReference
    private List<Procedure> procedure;

    public static Appointment convert(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .appointmentTime(appointmentRequest.getAppointmentTime())
                .barber(new Barber(appointmentRequest.getBarberId()))
                .customer(new Customer(appointmentRequest.getCustomerId()))
                .procedure(appointmentRequest.getProceduresId().stream()
                        .map(Procedure::new).toList())
                .build();
    }
}

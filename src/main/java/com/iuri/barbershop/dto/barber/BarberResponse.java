package com.iuri.barbershop.dto.barber;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Barber;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BarberResponse {

    private Integer id;
    private String name;
    private List<Appointment> appointments;

    public static BarberResponse convert(Barber barber){
        return BarberResponse.builder()
                .id(barber.getId())
                .name(barber.getName())
                .appointments(barber.getAppointments())
                .build();
    }
}

package com.iuri.barbershop.dto.procedure;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Procedure;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class procedureResponse {

    private Integer id;
    private String name;
    private Double price;
    private List<Appointment> appointments;

    public static procedureResponse convert(Procedure procedure){
        return procedureResponse.builder()
                .name(procedure.getName())
                .price(procedure.getPrice())
                .appointments(procedure.getAppointments())
                .build();
    }
}
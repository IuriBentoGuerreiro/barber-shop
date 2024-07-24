package com.iuri.barbershop.dto.procedure;

import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.model.Procedure;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProcedureResponse {

    private Integer id;
    private String name;
    private Double price;
    private List<Appointment> appointments;

    public static ProcedureResponse convert(Procedure procedure){
        return ProcedureResponse.builder()
                .id(procedure.getId())
                .name(procedure.getName())
                .price(procedure.getPrice())
                .appointments(procedure.getAppointments())
                .build();
    }
}

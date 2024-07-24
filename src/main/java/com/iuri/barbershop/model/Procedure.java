package com.iuri.barbershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuri.barbershop.dto.procedure.ProcedureRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "barbershop_procedure")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "procedure")
    private List<Appointment> appointments;

    public Procedure(Integer id){
        this.id = id;
    }

    public static Procedure convert(ProcedureRequest procedureRequest){
        return Procedure.builder()
                .name(procedureRequest.getName())
                .price(procedureRequest.getPrice())
                .build();
    }
}

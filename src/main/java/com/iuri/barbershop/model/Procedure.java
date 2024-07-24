package com.iuri.barbershop.model;

import com.iuri.barbershop.dto.procedure.procedureRequest;
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

    @OneToMany(mappedBy = "procedure")
    private List<Appointment> appointments;

    public Procedure(Integer id){
        this.id = id;
    }

    public static Procedure convert(procedureRequest procedureRequest){
        return Procedure.builder()
                .name(procedureRequest.getName())
                .price(procedureRequest.getPrice())
                .build();
    }
}

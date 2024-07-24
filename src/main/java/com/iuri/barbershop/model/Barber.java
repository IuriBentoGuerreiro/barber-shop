package com.iuri.barbershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuri.barbershop.dto.barber.BarberRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "barber")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "barber")
    private List<Appointment> appointments;

    public Barber(Integer id){
        this.id = id;
    }

    public static Barber convert(BarberRequest barberRequest){
        return Barber.builder()
                .name(barberRequest.getName())
                .build();
    }
}

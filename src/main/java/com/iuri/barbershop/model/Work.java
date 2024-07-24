package com.iuri.barbershop.model;

import com.iuri.barbershop.dto.service.ServiceRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "work")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments;

    public Work(Integer id){
        this.id = id;
    }

    public static Work convert(ServiceRequest serviceRequest){
        return Work.builder()
                .name(serviceRequest.getName())
                .price(serviceRequest.getPrice())
                .build();
    }
}

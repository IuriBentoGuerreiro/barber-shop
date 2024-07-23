package com.iuri.barbershop.model;

import com.iuri.barbershop.dto.service.ServiceRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments;

    public static Service convert(ServiceRequest serviceRequest){
        return Service.builder()
                .name(serviceRequest.getName())
                .price(serviceRequest.getPrice())
                .build();
    }
}

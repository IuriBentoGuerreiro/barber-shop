package com.iuri.barbershop.model;

import com.iuri.barbershop.dto.customer.CustomerRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;

    public Customer(Integer id){
        this.id = id;
    }

    public static Customer convert(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .phoneNumber(customerRequest.getPhoneNumber())
                .build();
    }
}

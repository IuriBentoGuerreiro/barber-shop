package com.iuri.barbershop.repository;

import com.iuri.barbershop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

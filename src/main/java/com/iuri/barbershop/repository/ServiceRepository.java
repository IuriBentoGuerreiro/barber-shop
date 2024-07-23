package com.iuri.barbershop.repository;

import com.iuri.barbershop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}

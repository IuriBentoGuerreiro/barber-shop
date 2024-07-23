package com.iuri.barbershop.repository;

import com.iuri.barbershop.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Integer> {
}

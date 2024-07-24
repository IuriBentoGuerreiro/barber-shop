package com.iuri.barbershop.repository;

import com.iuri.barbershop.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Procedure, Integer> {
}

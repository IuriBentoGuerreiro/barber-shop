package com.iuri.barbershop.service;

import com.iuri.barbershop.dto.barber.BarberRequest;
import com.iuri.barbershop.dto.barber.BarberResponse;
import com.iuri.barbershop.model.Barber;
import com.iuri.barbershop.repository.BarberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

    public BarberResponse save(BarberRequest barberRequest){
        return BarberResponse.convert(barberRepository.save(Barber.convert(barberRequest)));
    }

    public List<BarberResponse> findAll(){
        return barberRepository.findAll().stream()
                .map(BarberResponse::convert).toList();
    }

    public Barber findById(Integer id){
        return barberRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public Barber update(BarberRequest barberRequest, Integer id){
        var barberUpdate = findById(id);
        BeanUtils.copyProperties(barberRequest, barberUpdate, "id");
        return barberRepository.save(barberUpdate);
    }

    public void delete(Integer id){
        barberRepository.deleteById(id);
    }
}

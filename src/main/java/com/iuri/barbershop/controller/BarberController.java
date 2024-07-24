package com.iuri.barbershop.controller;

import com.iuri.barbershop.dto.barber.BarberRequest;
import com.iuri.barbershop.dto.barber.BarberResponse;
import com.iuri.barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barber")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @PostMapping
    public BarberResponse save(@RequestBody BarberRequest barberRequest){
        return barberService.save(barberRequest);
    }

    @GetMapping
    public List<BarberResponse> findAll(){
        return barberService.findAll();
    }

    @GetMapping("/{id}")
    public BarberResponse findById(@PathVariable Integer id){
        return BarberResponse.convert(barberService.findById(id));
    }

    @PutMapping("/{id}")
    public BarberResponse update(@RequestBody BarberRequest barberRequest, @PathVariable Integer id){
        return BarberResponse.convert(barberService.update(barberRequest, id));
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){
        barberService.delete(id);
    }
}

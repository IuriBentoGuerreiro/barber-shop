package com.iuri.barbershop.controller;

import com.iuri.barbershop.dto.appointment.AppointmentRequest;
import com.iuri.barbershop.dto.appointment.AppointmentResponse;
import com.iuri.barbershop.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponse save(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.save(appointmentRequest);
    }

    @GetMapping
    public List<AppointmentResponse> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public AppointmentResponse findById(@PathVariable Integer id){
        return AppointmentResponse.convert(appointmentService.findById(id));
    }

    @PutMapping("/{id}")
    public AppointmentResponse update(@RequestBody AppointmentRequest appointmentRequest, @PathVariable Integer id){
        return AppointmentResponse.convert(appointmentService.update(appointmentRequest, id));
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){
        appointmentService.delete(id);
    }
}

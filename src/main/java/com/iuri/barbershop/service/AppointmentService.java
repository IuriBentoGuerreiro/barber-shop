package com.iuri.barbershop.service;

import com.iuri.barbershop.dto.appointment.AppointmentRequest;
import com.iuri.barbershop.dto.appointment.AppointmentResponse;
import com.iuri.barbershop.model.Appointment;
import com.iuri.barbershop.repository.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentResponse save(AppointmentRequest appointmentRequest){
        return AppointmentResponse.convert(appointmentRepository.save(Appointment.convert(appointmentRequest)));
    }

    public List<AppointmentResponse> findAll(){
        return appointmentRepository.findAll().stream()
                .map(AppointmentResponse::convert).toList();
    }

    public Appointment findById(Integer id){
        return appointmentRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public Appointment update(AppointmentRequest appointmentRequest, Integer id){
        var appointmentUpdate = findById(id);
        BeanUtils.copyProperties(appointmentRequest, appointmentUpdate, "id");
        return appointmentRepository.save(appointmentUpdate);
    }

    public void delete(Integer id){
        appointmentRepository.deleteById(id);
    }
}

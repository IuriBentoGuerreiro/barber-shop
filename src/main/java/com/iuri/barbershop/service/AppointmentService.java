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

    private final AppointmentRepository appointmentRepository;
    private final BarberService barberService;
    private final CustomerService customerService;
    private final ProcedureService procedureService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                            BarberService barberService,
                            CustomerService customerService,
                            ProcedureService procedureService) {
        this.appointmentRepository = appointmentRepository;
        this.barberService = barberService;
        this.customerService = customerService;
        this.procedureService = procedureService;
    }

    public AppointmentResponse save(AppointmentRequest appointmentRequest){
        var appointment = appointmentRepository.save(Appointment.builder()
                        .appointmentTime(appointmentRequest.getAppointmentTime())
                        .barber(barberService.findById(appointmentRequest.getBarberId()))
                        .customer(customerService.findById(appointmentRequest.getCustomerId()))
                        .procedure(procedureService.findAllById(appointmentRequest.getProceduresId()))
                .build());

        return AppointmentResponse.convert(appointmentRepository.save(appointment));
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

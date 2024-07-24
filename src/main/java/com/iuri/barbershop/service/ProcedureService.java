package com.iuri.barbershop.service;

import com.iuri.barbershop.dto.procedure.ProcedureRequest;
import com.iuri.barbershop.dto.procedure.ProcedureResponse;
import com.iuri.barbershop.model.Procedure;
import com.iuri.barbershop.repository.ProcedureRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    public ProcedureResponse save(ProcedureRequest procedureRequest){
        return ProcedureResponse.convert(procedureRepository.save(Procedure.convert(procedureRequest)));
    }

    public List<ProcedureResponse> findAll(){
        return procedureRepository.findAll().stream()
                .map(ProcedureResponse::convert).toList();
    }

    public Procedure findById(Integer id){
        return procedureRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public Procedure update(ProcedureRequest procedureRequest, Integer id){
        var procedureUpdate = findById(id);
        BeanUtils.copyProperties(procedureRequest, procedureUpdate, "id");
        return procedureRepository.save(procedureUpdate);
    }

    public void delete(Integer id){
        procedureRepository.deleteById(id);
    }
}

package com.iuri.barbershop.controller;

import com.iuri.barbershop.dto.procedure.ProcedureRequest;
import com.iuri.barbershop.dto.procedure.ProcedureResponse;
import com.iuri.barbershop.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @PostMapping
    public ProcedureResponse save(@RequestBody ProcedureRequest procedureRequest){
        return procedureService.save(procedureRequest);
    }

    @GetMapping
    public List<ProcedureResponse> findAll(){
        return procedureService.findAll();
    }

    @GetMapping("/{id}")
    public ProcedureResponse findById(@PathVariable Integer id){
        return ProcedureResponse.convert(procedureService.findById(id));
    }

    @PutMapping("/{id}")
    public ProcedureResponse update(@RequestBody ProcedureRequest procedureRequest, @PathVariable Integer id){
        return ProcedureResponse.convert(procedureService.update(procedureRequest, id));
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){
        procedureService.delete(id);
    }
}

package com.iuri.barbershop.controller;

import com.iuri.barbershop.dto.customer.CustomerRequest;
import com.iuri.barbershop.dto.customer.CustomerResponse;
import com.iuri.barbershop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse save(@RequestBody CustomerRequest customerRequest){
        return customerService.save(customerRequest);
    }

    @GetMapping
    public List<CustomerResponse> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Integer id){
        return CustomerResponse.convert(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@RequestBody CustomerRequest customerRequest, @PathVariable Integer id){
        return CustomerResponse.convert(customerService.update(customerRequest, id));
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }
}

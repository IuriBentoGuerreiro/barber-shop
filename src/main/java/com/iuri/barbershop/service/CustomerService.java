package com.iuri.barbershop.service;

import com.iuri.barbershop.dto.customer.CustomerRequest;
import com.iuri.barbershop.dto.customer.CustomerResponse;
import com.iuri.barbershop.model.Customer;
import com.iuri.barbershop.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse save(CustomerRequest customerRequest){
        return CustomerResponse.convert(customerRepository.save(Customer.convert(customerRequest)));
    }

    public List<CustomerResponse> findAll(){
        return customerRepository.findAll().stream()
                .map(CustomerResponse::convert).toList();
    }

    public Customer findById(Integer id){
        return customerRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }

    public Customer update(CustomerRequest customerRequest, Integer id){
        var customerUpdate = findById(id);
        BeanUtils.copyProperties(customerRequest, customerUpdate, "id");
        return customerRepository.save(customerUpdate);
    }

    public void delete(Integer id){
        customerRepository.deleteById(id);
    }
}

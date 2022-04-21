package com.shortlymsg.account.service;

import com.shortlymsg.account.exception.CustomerNotFoundException;
import com.shortlymsg.account.model.Customer;
import com.shortlymsg.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: "+ id));
    }
}

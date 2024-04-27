package com.microservice.orderservice.service;

import com.microservice.orderservice.Entity.Customer;
import com.microservice.orderservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Customer addCustomer(Customer customer) throws Exception {

        Customer c = customerRepository.saveAndFlush(customer);
        return c;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addCustomer2(Customer customer) {
                customerRepository.save(customer);

    }
}

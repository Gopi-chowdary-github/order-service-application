package com.microservice.orderservice;

import com.microservice.orderservice.Entity.City;
import com.microservice.orderservice.Entity.Customer;
import com.microservice.orderservice.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CreateCustomer {

    @Autowired
    CustomerRepository customerRepository;

   @PostConstruct
   void addCustomers(){
     //  IntStream.range(0, 50).mapToObj(x -> new City("city"+x,"cou"+x,"reg"+x)).collect(Collectors.toList());
     // Random a = new Random();
    // List<Customer> cus = IntStream.range(0, 50).mapToObj(x -> new Customer("customer" + x,  a.nextInt(100000,111111111)+" " + x,new City("city"+x,a.nextInt(0,100)+"cou"+x,"reg"+x))).collect(Collectors.toList());customerRepository.saveAll(cus);
    }
}

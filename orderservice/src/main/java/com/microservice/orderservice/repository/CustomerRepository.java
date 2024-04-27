package com.microservice.orderservice.repository;

import com.microservice.orderservice.Entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByNameContainingIgnoringCaseAndPhno(String name,String phno);
    List<Customer> findAllByOrderByPhnoAsc();
    List<Customer> findAllByOrderByPhnoDesc();
}

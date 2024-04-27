package com.microservice.orderservice.contorller;

import com.microservice.orderservice.APIResponse;
import com.microservice.orderservice.Entity.Customer;
import com.microservice.orderservice.aop.TransactionalAnn;
import com.microservice.orderservice.repository.CustomerRepository;
import com.microservice.orderservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    CustomerService  CustomerService;
   @PostMapping("/addCustomer")
   @TransactionalAnn(value ="intercept")
   ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
     Customer customer1=   CustomerService.addCustomer(customer);
     return  new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }
    @GetMapping("/getCustomer/{id}")
    @PreAuthorize("hasRole('HR')")
    ResponseEntity<Customer> addCustomer(@PathVariable Long id){
        Optional<Customer> customer1=   customerRepository.findById(id);
        return  new ResponseEntity<>(customer1.get(),HttpStatus.OK);
    }
   @GetMapping("/byPhnAsc")
   @PreAuthorize("hasAuthority('Admin')")
   ResponseEntity<List<Customer>> getCustomerByPhnoAsc(){
        List<Customer> c = customerRepository.findAllByOrderByPhnoAsc();

        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @GetMapping("/byPhnDesc")
    ResponseEntity<List<Customer>> getCustomerByPhnoDsc(){
        List<Customer> c = customerRepository.findAllByOrderByPhnoDesc();
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @GetMapping("/getCustomerByOrder/{field}")
    public APIResponse<List<Customer>> getCustomerByOrder(@PathVariable  String field ){
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return new APIResponse<>(customers.size(),customers);
    }
    @GetMapping("/getCustomerByOrderForPagination/{offset}/{limit}/{field}")
    public APIResponse<Page<Customer> > getCustomerByOrderForPagination(@PathVariable  int offset,@PathVariable int limit,@PathVariable String field ){
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(offset, limit).withSort(Sort.Direction.ASC,field));
        return new APIResponse<>(customers.getSize(),customers);
    }
}

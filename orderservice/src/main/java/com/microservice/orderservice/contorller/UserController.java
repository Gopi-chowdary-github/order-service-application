package com.microservice.orderservice.contorller;

import com.microservice.orderservice.Entity.Role;
import com.microservice.orderservice.domain.UserInfo;
import com.microservice.orderservice.repository.RoleRepository;
import com.microservice.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


   @Autowired
   UserService userService;

    @Autowired
    private RoleRepository roleRepository;
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserInfo userInfo){
        userService.addUser(userInfo);
        return  new ResponseEntity<>("UserAdded successfully" , HttpStatus.CREATED);
    }
    @PostMapping("/addRole")
    public ResponseEntity<?> addRoles(@RequestBody List<Role> roles){
        roleRepository.saveAll(roles);
        return  new ResponseEntity<>("Roles Added successfully" , HttpStatus.CREATED);
    }

}

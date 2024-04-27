package com.microservice.orderservice.service;

import com.microservice.orderservice.Entity.Role;
import com.microservice.orderservice.Entity.User;
import com.microservice.orderservice.domain.UserInfo;
import com.microservice.orderservice.repository.RoleRepository;
import com.microservice.orderservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.RouterFunctionDslKt;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

   @Autowired
   private PasswordEncoder encoder;




    public void addUser(UserInfo userInfo) {
            User user = new User();
            List<Role> roles = new ArrayList<>();

            user.setName(userInfo.getName());
            user.setPassword( encoder.encode(userInfo.getPassword()));
            user.setEmail(userInfo.getEmail());
            user.setRoles(userInfo.getRole());

        userRepository.save(user);
    }
}

package com.microservice.orderservice.repository;

import com.microservice.orderservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    Optional<User> findById(Long aLong);

    Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByName(String username);
}

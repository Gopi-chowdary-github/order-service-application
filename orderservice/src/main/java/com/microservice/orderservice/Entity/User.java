package com.microservice.orderservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long Id;
   @Column(name = "name")
   String name;

   @Column
   String password;
   @Column(nullable = false)
   String email;

   @ManyToMany(fetch=FetchType.EAGER)
   List<Role> roles;

}

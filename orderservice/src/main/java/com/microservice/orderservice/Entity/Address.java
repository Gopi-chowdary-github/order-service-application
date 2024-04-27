package com.microservice.orderservice.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="address")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Country;
    private String State;
    private Long Pincode;
}

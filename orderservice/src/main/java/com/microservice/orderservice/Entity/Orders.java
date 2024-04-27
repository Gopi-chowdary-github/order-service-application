package com.microservice.orderservice.Entity;

import com.microservice.orderservice.Entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer-orders")
@Getter
@Setter
@Data
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String req_id;
   @OneToOne(fetch = FetchType.LAZY)
   Customer customerTable;

}

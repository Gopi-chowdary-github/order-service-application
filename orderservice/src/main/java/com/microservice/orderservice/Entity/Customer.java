package com.microservice.orderservice.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "customer-table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(nullable=false)
    String name;
    String phno;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city-fk", referencedColumnName = "cityid")
    private City city;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer-fk", referencedColumnName = "id")
    private List<Address> address;



    public Customer(String s, String s1, City city) {
        this.name = s;
        this.phno = s1;
        this.city = city;

    }


}

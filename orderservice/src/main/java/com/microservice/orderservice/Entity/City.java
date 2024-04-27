package com.microservice.orderservice.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="city")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cityid;

    String city_name;
    String country;

    String region;

    public City(String s, String s1, String s2) {
        this.city_name=s;
        this.country=s1;
        this.region=s2;
    }
}

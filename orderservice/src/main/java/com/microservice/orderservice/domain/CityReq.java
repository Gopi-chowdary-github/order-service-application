package com.microservice.orderservice.domain;

import lombok.Data;

@Data
public class CityReq {

    String city_name;
    String country;

    String region;
}

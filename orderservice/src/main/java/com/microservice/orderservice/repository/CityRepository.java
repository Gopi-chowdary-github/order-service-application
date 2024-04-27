package com.microservice.orderservice.repository;

import com.microservice.orderservice.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    List<City> findByRegionAndCityidGreaterThan(String region,Long id);
    List<City> findByRegionAndCountry(String region,String country);

  @Transactional
  void deleteByRegion(String region);

   List<City> findByCityidGreaterThan(Long city_id);

    List<City> findByRegion(String region);
}

package com.microservice.orderservice.contorller;

import com.microservice.orderservice.Entity.City;
import com.microservice.orderservice.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityRepository cityRepository;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addCity")
    public City addCity(@RequestBody City city){
       return cityRepository.save(city);
     };
    @PostMapping("/addCities")
    public List<City> addCities(@RequestBody List<City> city){
        return cityRepository.saveAll(city);
    };


    @GetMapping("/getCities/{region}")
    @PreAuthorize("hasRole('Tester')")
    public ResponseEntity<List<City>> getCitieByRegion(@PathVariable String region){
        List<City> cities = cityRepository.findByRegion(region);

        return new ResponseEntity<>(cities,HttpStatus.OK);
    }

    @GetMapping("/getCities/{region}/{id}")
    public ResponseEntity<List<City>> getCitiesByRegion(@PathVariable Long id,@PathVariable String region){
        List<City> cities = cityRepository.findByRegionAndCityidGreaterThan(region,id);

        return new ResponseEntity<>(cities,HttpStatus.OK);
    }
    @GetMapping("/getCitiesByRegionAndId/{region}/{country}")
    public ResponseEntity<List<City>> getCitiesByRegionAndCountry(@PathVariable String region,@PathVariable String country){
        List<City> cities = cityRepository.findByRegionAndCountry(region,country);

        return new ResponseEntity<>(cities,HttpStatus.OK);
    }
    @DeleteMapping ("/deleteCities/{region}")
    public ResponseEntity getCitiesByRegionAndCountry(@PathVariable String region){
        cityRepository.deleteByRegion( region);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

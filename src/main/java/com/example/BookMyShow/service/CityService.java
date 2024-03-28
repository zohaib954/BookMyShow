package com.example.BookMyShow.service;

import com.example.BookMyShow.model.City;
import com.example.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String name,
                         String streetName,
                         String district,
                         String state,
                         String zipCode){
        City city = new City();
        city.setName(name);
        city.setStreetName(streetName);
        city.setDistrict(district);
        city.setState(state);
        city.setZipCode(zipCode);

        return cityRepository.save(city);
    }

    public boolean deleteCityById(int id){
        cityRepository.deleteById(id);
        return true;
    }

    public City getCityByName(String name){
        return cityRepository.findCityByName(name);
    }

    public City getCityById(int id) {
        return cityRepository.getById(id);

    }
}

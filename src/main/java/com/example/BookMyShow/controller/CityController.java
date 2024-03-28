package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.CityRequestDTO;
import com.example.BookMyShow.model.City;
import com.example.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody CityRequestDTO cityRequestDTO){
        City savedCity = null;
        try{
            String cityName = cityRequestDTO.getName();
            String district = cityRequestDTO.getDistrict();
            String state = cityRequestDTO.getState();
            String zipCode = cityRequestDTO.getZipCode();
            if(cityName == null || cityName.isEmpty() || cityName.isBlank() ||
                    district == null || district.isEmpty() || district.isBlank() ||
                    state == null || state.isEmpty() || state.isBlank() ||
                    zipCode == null || zipCode.isEmpty() || zipCode.isBlank()){
                throw new Exception("Check city details, cityName, district, state and zipCode should not be null or empty");
            }
             savedCity = cityService.saveCity(cityName,cityRequestDTO.getStreetName(), district, state, zipCode);
        }
        catch (Exception e){
            e.printStackTrace();
        }
           return new ResponseEntity<>(savedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable("id") int id){
        boolean deletedCity = cityService.deleteCityById(id);
        if(deletedCity){
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("city not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}")
    public ResponseEntity<City> getCityByName(@PathVariable("name") String name){
        City city = cityService.getCityByName(name);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

}

package com.example.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRequestDTO {
    private String name;
    private String streetName;
    private String district;
    private String state;
    private String zipCode;
}

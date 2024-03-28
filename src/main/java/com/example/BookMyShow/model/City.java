package com.example.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;
    private String streetName;
    private String district;
    private String state;
    private String zipCode;
    @OneToMany
    private List<Theatre> theatres;
}

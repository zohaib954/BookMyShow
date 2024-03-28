package com.example.BookMyShow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    @Column(name = "THEATRE_NAME")
    private String theatreName;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;
}

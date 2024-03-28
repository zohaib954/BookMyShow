package com.example.BookMyShow.model;

import com.example.BookMyShow.model.constants.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    @Column(name = "AUDITORIUM_NAME")
    private String name;
    private int capacity;
    @OneToMany
    private List<Show> shows;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection // used when Enum is in multiple, ie, a datastructures ex - List, Set etc.
    @Enumerated(EnumType.STRING) // creates a relationship between the entity class and the enum in DB
    private List<AuditoriumFeatures> features;
}

package com.example.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "_USER")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String email;
    @OneToMany
    private List<Ticket> tickets;
}

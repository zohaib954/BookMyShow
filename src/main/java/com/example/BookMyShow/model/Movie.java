package com.example.BookMyShow.model;

import com.example.BookMyShow.model.constants.Genre;
import com.example.BookMyShow.model.constants.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    private String desc;
    @ManyToMany
    private List<Actor> actors;
    private String duration;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private Language language;
}

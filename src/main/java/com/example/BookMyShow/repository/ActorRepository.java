package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}

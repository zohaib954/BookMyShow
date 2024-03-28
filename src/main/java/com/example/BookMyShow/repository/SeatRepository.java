package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}

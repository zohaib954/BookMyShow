package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.BookTicketRequestDTO;
import com.example.BookMyShow.model.Ticket;
import com.example.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        //to do validate ticket request dto

        Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getShowSeatsIds(),
                bookTicketRequestDTO.getUserId());
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
   

}

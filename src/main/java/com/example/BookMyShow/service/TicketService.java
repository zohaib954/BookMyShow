package com.example.BookMyShow.service;

import com.example.BookMyShow.model.ShowSeat;
import com.example.BookMyShow.model.Ticket;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.model.constants.SeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, Integer userId) throws Exception {
        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeatById(showSeatId);
            if(!seat.getSeatAvailability().equals(SeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available");
            }
        }

        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeatById(showSeatId);
            seat.setSeatAvailability(SeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
        return new Ticket();
    }
}

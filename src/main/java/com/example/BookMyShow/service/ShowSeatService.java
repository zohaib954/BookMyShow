package com.example.BookMyShow.service;

import com.example.BookMyShow.model.ShowSeat;
import com.example.BookMyShow.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeatById(int showSeatId){
        if(showSeatRepository.findById(showSeatId).isPresent())
            return showSeatRepository.findById(showSeatId).get();
        return null;
    }

    public ShowSeat saveShowSeat(ShowSeat seat) {
        return showSeatRepository.save(seat);
    }
}

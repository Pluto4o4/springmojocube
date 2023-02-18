package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.service.impl.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.gxa.springmojocube.utils.Result;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation/query")
    public Result queryAll(){
       List<Reservation> reservations = this.reservationService.queryAll();

        return new Result().ok(reservations);
    }
}

package com.gxa.springmojocube.service.impl.impl;

import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.mapper.ReservationMapper;
import com.gxa.springmojocube.service.impl.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired(required = false)
    private ReservationMapper reservationMapper;

    @Override
    public List<Reservation> queryAll() {
        List<Reservation> reservations = this.reservationMapper.queryAll();
        return reservations;
    }
}

package com.gxa.springmojocube.service.impl.impl;

import com.gxa.springmojocube.entity.Patient;
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

    @Override
    public void deleteById(Reservation reservation) {
       this.reservationMapper.deleteById(reservation);
    }

    @Override
    public void add(Reservation reservation) {
        this.reservationMapper.add(reservation);
    }

    @Override
    public void deleteByIds(String[] ids) {
        this.reservationMapper.deleteByIds(ids);
    }

    @Override
    public Reservation selectById(Reservation reservation) {
        this.reservationMapper.selectById(reservation);
        return null;
    }

    @Override
    public void updateById(Reservation reservation) {
        this.reservationMapper.updateById(reservation);
    }

    @Override
    public List<Patient> selectAllpatient() {
        return this.reservationMapper.selectAllpatient();
    }

    @Override
    public void updateByPatientId(Patient patient) {
       this.reservationMapper.updateByPatientId(patient);
    }

    @Override
    public Patient selectByPatientId(Patient patient) {
        return this.reservationMapper.selectByPatientId(patient);
    }
}

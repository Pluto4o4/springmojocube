package com.gxa.springmojocube.service.impl;


import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.utils.Result;
import java.util.List;

public interface ReservationService {
    List<Reservation> queryAll();
    void deleteById(Reservation reservation);

    void add(Reservation reservation);

    void deleteByIds(String[] ids);

    Result selectById(Reservation reservation);

    boolean updateById(Reservation reservation);

    List<Patient> selectAllpatient();

    void updateByPatientId(Patient patient);

    Patient selectByPatientId(Patient patient);
}

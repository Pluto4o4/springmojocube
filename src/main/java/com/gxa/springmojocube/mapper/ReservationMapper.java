package com.gxa.springmojocube.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.entity.Reservation;
import java.util.List;

public interface ReservationMapper extends BaseMapper<Reservation> {

    List<Reservation> queryAll();

    int deleteById(Reservation reservation);

    void add(Reservation reservation);

    void deleteByIds(String[] ids);

    Reservation selectById(Integer index,Integer size,Reservation reservation);

    int updateById(Reservation reservation);

    List<Patient> selectAllpatient();

    void updateByPatientId(Patient patient);

    Patient selectByPatientId(Patient patient);
}

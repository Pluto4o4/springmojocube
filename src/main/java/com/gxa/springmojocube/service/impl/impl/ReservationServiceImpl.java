package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.mapper.ReservationMapper;
import com.gxa.springmojocube.service.impl.ReservationService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
    implements ReservationService {

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
  public Result selectById(Reservation reservation) {
    if(reservation.getIndex()==""||reservation.getIndex()==null){
      reservation.setIndex("1");
    }
    if(reservation.getSize()==""||reservation.getSize()==null){
      reservation.setSize("10");
    }
    Integer pageNumber= Integer.valueOf(reservation.getIndex());
    Integer pageSize= Integer.valueOf(reservation.getSize());
    Page<Reservation> page =
        query()
            .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_name()),
                "user_name",
                reservation.getUser_name())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_sex()),
                "user_sex",
                reservation.getUser_sex())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_age()),
                "user_age",
                reservation.getUser_age())
            .eq(StringUtils.isNotBlank(reservation.getPhone()), "phone", reservation.getPhone())
            .eq(
                StringUtils.isNotBlank(reservation.getAddress()),
                "address",
                reservation.getAddress())
            .eq(StringUtils.isNotBlank(reservation.getStatus()), "status", reservation.getStatus())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_appoint()),
                "user_appoint",
                reservation.getUser_appoint())
            .eq(
                StringUtils.isNotBlank(reservation.getDepartment()),
                "department",
                reservation.getDepartment())
            .eq(
                StringUtils.isNotBlank(reservation.getCreate_time()),
                "create_time",
                reservation.getCreate_time())
            .eq(
                StringUtils.isNotBlank(reservation.getAppoint_time()),
                "appoint_time",
                reservation.getAppoint_time())
            .page(new Page<>(pageNumber, pageSize));

    List<Reservation> list = page.getRecords();
    Long size =
        query()
            .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_name()),
                "user_name",
                reservation.getUser_name())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_sex()),
                "user_sex",
                reservation.getUser_sex())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_age()),
                "user_age",
                reservation.getUser_age())
            .eq(StringUtils.isNotBlank(reservation.getPhone()), "phone", reservation.getPhone())
            .eq(
                StringUtils.isNotBlank(reservation.getAddress()),
                "address",
                reservation.getAddress())
            .eq(StringUtils.isNotBlank(reservation.getStatus()), "status", reservation.getStatus())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_appoint()),
                "user_appoint",
                reservation.getUser_appoint())
            .eq(
                StringUtils.isNotBlank(reservation.getDepartment()),
                "department",
                reservation.getDepartment())
            .eq(
                StringUtils.isNotBlank(reservation.getCreate_time()),
                "create_time",
                reservation.getCreate_time())
            .eq(
                StringUtils.isNotBlank(reservation.getAppoint_time()),
                "appoint_time",
                reservation.getAppoint_time())
            .count();

    return new Result().ok(list, size.toString());
  }

  @Override
  public boolean updateById(Reservation reservation) {
    int i = this.reservationMapper.updateById(reservation);
    return true;
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

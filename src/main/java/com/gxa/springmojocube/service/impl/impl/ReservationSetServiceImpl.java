package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.mapper.ReservationSetMapper;
import com.gxa.springmojocube.service.impl.ReservationSetService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 预约管理设置
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 11:45
 */

@Service
public class ReservationSetServiceImpl extends ServiceImpl<ReservationSetMapper,AppointSet> implements ReservationSetService {
  @Autowired(required = false)
private ReservationSetMapper reservationSetMapper;
  @Override
  public List<AppointSet> queryAll() {
    List<AppointSet> appointSets=this.reservationSetMapper.queryAll();
    return appointSets;
  }

  @Override
  public void deleteById(AppointSet appointSet) {
    this.reservationSetMapper.deleteById(appointSet);
  }

  @Override
  public void add(AppointSet reservation) {
    this.reservationSetMapper.add(reservation);
  }

  @Override
  public Result selectById(AppointSet reservation) {
    if(reservation.getIndex()==""||reservation.getIndex()==null){
      reservation.setIndex("1");
    }
    if(reservation.getSize()==""||reservation.getSize()==null){
      reservation.setSize("10");
    }
    Integer pageNumber= Integer.valueOf(reservation.getIndex());
    Integer pageSize= Integer.valueOf(reservation.getSize());
    Page<AppointSet> page =
        query()
            .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
            .eq(StringUtils.isNotBlank(reservation.getUser_appoint()), "user_appoint", reservation.getUser_appoint())
            .eq(StringUtils.isNotBlank(reservation.getStatus()), "status", reservation.getStatus())
            .eq(StringUtils.isNotBlank(reservation.getOccupation()), "occupation", reservation.getOccupation())
            .eq(
                StringUtils.isNotBlank(reservation.getUser_appoint()),
                "user_appoint",
                reservation.getUser_appoint())
            .eq(
                StringUtils.isNotBlank(reservation.getDepartment()),
                "department",
                reservation.getDepartment())
            .eq(
                StringUtils.isNotBlank(reservation.getAppoint_time()),
                "appoint_time",
                reservation.getAppoint_time())
            .page(new Page<>(pageNumber, pageSize));

    List<AppointSet> list = page.getRecords();
    Long size1 =
    query()
        .eq(StringUtils.isNotBlank(reservation.getId()), "id", reservation.getId())
        .eq(StringUtils.isNotBlank(reservation.getUser_appoint()), "user_appoint", reservation.getUser_appoint())
        .eq(StringUtils.isNotBlank(reservation.getStatus()), "status", reservation.getStatus())
        .eq(StringUtils.isNotBlank(reservation.getOccupation()), "occupation", reservation.getOccupation())
        .eq(
            StringUtils.isNotBlank(reservation.getUser_appoint()),
            "user_appoint",
            reservation.getUser_appoint())
        .eq(
            StringUtils.isNotBlank(reservation.getDepartment()),
            "department",
            reservation.getDepartment())
        .eq(
            StringUtils.isNotBlank(reservation.getAppoint_time()),
            "appoint_time",
            reservation.getAppoint_time())
        .count();

    return new Result().ok(list, size1.toString());
  }

  @Override
  public boolean updateById(AppointSet reservation) {
    this.reservationSetMapper.updateById(reservation);
    return true;
  }
}

package com.gxa.springmojocube.service.impl.impl;

import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.mapper.ReservationSetMapper;
import com.gxa.springmojocube.service.impl.ReservationSetService;
import java.util.List;
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
public class ReservationSetServiceImpl implements ReservationSetService {
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
  public AppointSet selectById(AppointSet reservation) {
    return this.reservationSetMapper.selectById(reservation);
  }

  @Override
  public void updateById(AppointSet reservation) {
    this.reservationSetMapper.updateById(reservation);
  }
}

package com.gxa.springmojocube.mapper;

import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.entity.Reservation;
import java.util.List;

public interface ReservationSetMapper {

  List<AppointSet> queryAll();

  void deleteById(AppointSet appointSet);

  void add(AppointSet reservation);

  AppointSet selectById(AppointSet reservation);

  void updateById(AppointSet reservation);
}

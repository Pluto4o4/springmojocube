package com.gxa.springmojocube.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.springmojocube.entity.AppointSet;
import java.util.List;

public interface ReservationSetMapper extends BaseMapper<AppointSet> {

  List<AppointSet> queryAll();

  int deleteById(AppointSet appointSet);

  void add(AppointSet reservation);

  //AppointSet selectById(AppointSet reservation);

  int updateById(AppointSet reservation);
}

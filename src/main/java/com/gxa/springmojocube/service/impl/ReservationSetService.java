package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.utils.Result;
import java.util.List;

/**
 * 患者管理设置
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 11:44
 */
public interface ReservationSetService {

  List<AppointSet> queryAll();

  void deleteById(AppointSet appointSet);

  void add(AppointSet reservation);

  Result selectById(AppointSet reservation);

  boolean updateById(AppointSet reservation);
}

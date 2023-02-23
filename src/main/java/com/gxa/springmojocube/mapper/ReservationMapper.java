package com.gxa.springmojocube.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.springmojocube.entity.Reservation;

import java.util.List;

public interface ReservationMapper extends BaseMapper<Reservation> {

    List<Reservation> queryAll();
}

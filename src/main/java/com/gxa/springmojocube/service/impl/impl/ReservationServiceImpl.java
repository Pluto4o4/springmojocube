package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.mapper.ReservationMapper;
import com.gxa.springmojocube.service.impl.ReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements ReservationService {

//    @Autowired(required = false)
    @Resource
    private ReservationMapper reservationMapper;

    @Override
    public List<Reservation> queryAll() {
        List<Reservation> reservations = this.reservationMapper.queryAll();
        return reservations;
    }
}

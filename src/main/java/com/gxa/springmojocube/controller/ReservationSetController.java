package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.service.impl.ReservationSetService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预约设置Controller
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 11:43
 */
@RestController
public class ReservationSetController {

  @Autowired private ReservationSetService reservationSetService;

  // 查找所有设置
  @GetMapping("/reservationset/query")
  public Result queryAll() {
    List<AppointSet> reservations = this.reservationSetService.queryAll();
    System.out.println(reservations.toString());
    return new Result().ok(reservations);
  }

  // 根据id删除
  @PostMapping("/reservationset/deletById")
  public Result deletById(@RequestParam Integer id) {
    AppointSet appointSet=new AppointSet();
    appointSet.setId(String.valueOf(id));
    this.reservationSetService.deleteById(appointSet);
    return new Result().ok();
  }

  // 添加

  // 添加
  @PostMapping("/reservationset/add")
  public Result addById(@RequestBody AppointSet reservation) {
    this.reservationSetService.add(reservation);
    return new Result().ok();
  }

  // 根据id获取信息
  @PostMapping("/reservationset/selectById")
  public Result selectById(@RequestParam(defaultValue = "1") Integer index,
      @RequestParam(defaultValue = "10") Integer size,
      @RequestParam(required = false) String id,
      @RequestParam(required = false) String user_appoint,
      @RequestParam(required = false) String deparment,
      @RequestParam(required = false) String occupation,
      @RequestParam(required = false) String appoint_time,
      @RequestParam(required = false) String surplus,
      @RequestParam(required = false) String status) {
    AppointSet reservation= new AppointSet();
    reservation.setAppoint_time(appoint_time);
    reservation.setStatus(status);
    reservation.setDepartment(deparment);
    reservation.setId(id);
    reservation.setSize(String.valueOf(size));
    reservation.setIndex(String.valueOf(index));
    reservation.setOccupation(occupation);
    reservation.setSurplus(surplus);
    reservation.setUser_appoint(user_appoint);
    Result res = this.reservationSetService.selectById(reservation);
    return res;
  }

  // 修改
  @PostMapping("/reservationset/updateById")
  public Result updateById(@RequestBody AppointSet reservation) {
    this.reservationSetService.updateById(reservation);
    return new Result().ok();
  }
}

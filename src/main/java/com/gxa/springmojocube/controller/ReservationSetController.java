package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.AppointSet;
import com.gxa.springmojocube.service.impl.ReservationSetService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public Result deletById(@RequestBody AppointSet appointSet) {
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
  public Result selectById(@RequestBody AppointSet reservation) {
    AppointSet newreservation = this.reservationSetService.selectById(reservation);
    return new Result().ok(newreservation);
  }

  // 修改
  @PostMapping("/reservationset/updateById")
  public Result updateById(@RequestBody AppointSet reservation) {
    this.reservationSetService.updateById(reservation);
    return new Result().ok();
  }
}

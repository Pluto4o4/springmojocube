package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.entity.Reservation;
import com.gxa.springmojocube.service.impl.ReservationService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

  @Autowired private ReservationService reservationService;

  // 查找所有
  @GetMapping("/reservation/query")
  public Result queryAll() {
    List<Reservation> reservations = this.reservationService.queryAll();

    return new Result().ok(reservations);
  }

  // 根据id删除
  @PostMapping("/reservation/deletById")
  public Result deletById(@RequestBody Reservation reservation) {
    this.reservationService.deleteById(reservation);
    return new Result().ok();
  }

  // 添加
  @PostMapping("/reservation/add")
  public Result addById(@RequestBody Reservation reservation) {
    this.reservationService.add(reservation);
    return new Result().ok();
  }

  // 批量删除
  @PostMapping("/reservation/deleteByIds")
  public Result deleteByIds(@RequestBody String[] ids) {
    this.reservationService.deleteByIds(ids);
    return new Result().ok();
  }

  // 根据id获取信息
  @GetMapping("/reservation/selectById")
  public Result selectById(@RequestBody Reservation reservation) {
    Reservation newreservation = this.reservationService.selectById(reservation);
    return new Result().ok(newreservation);
  }

  // 修改
  @PostMapping("/reservation/updateById")
  public Result updateById(@RequestBody Reservation reservation) {
    this.reservationService.updateById(reservation);
    return new Result().ok();
  }

  // 预约管理-患者查询
  @GetMapping("/reservation/selectAllPatient")
  public Result selectAllPatient() {
    List<Patient> patients = this.reservationService.selectAllpatient();
    return new Result().ok(patients);
  }
  // 预约管理-修改患者预约天数
  @PostMapping("/reservation/updataByPatientId")
  public Result updataByPatientId(@RequestBody Patient patient) {
    this.reservationService.updateByPatientId(patient);
    return new Result().ok();
  }

  // 预约管理-根据id查询患者
  @GetMapping("/reservation/selectByPatientId")
  public Result selectByPatientId(@RequestBody Patient patient) {
    Patient newpatient = this.reservationService.selectByPatientId(patient);
    return new Result().ok(newpatient);
  }
}

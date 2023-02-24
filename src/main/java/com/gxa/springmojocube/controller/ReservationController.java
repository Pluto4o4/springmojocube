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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预约管理
 *
 * @author Mr.Xu/Pluto404
 * @since 8:31 2023/2/24
 * @version V1.0
 */
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
  public Result selectById(@RequestParam(defaultValue = "1") Integer index,
      @RequestParam(defaultValue = "10j") Integer size,
      @RequestParam(required = false) String user_name,
      @RequestParam(required = false) String user_sex,
      @RequestParam(required = false) String user_age,
      @RequestParam(required = false) String phone,
      @RequestParam(required = false) String address,
      @RequestParam(required = false) String status,
      @RequestParam(required = false) String user_appoint,
      @RequestParam(required = false) String department,
      @RequestParam(required = false) String create_time,
      @RequestParam(required = false) String appoint_time) {
    Reservation reservation=new Reservation();
    reservation.setSize(String.valueOf(size));
    reservation.setIndex(String.valueOf(index));
    reservation.setUser_age(user_age);
    reservation.setUser_name(user_name);
    reservation.setUser_sex(user_sex);
    reservation.setPhone(phone);
    reservation.setAddress(address);
    reservation.setStatus(status);
    reservation.setUser_appoint(user_appoint);
    reservation.setDepartment(department);
    reservation.setCreate_time(create_time);
    reservation.setAppoint_time(appoint_time);
    Result result = this.reservationService.selectById(reservation);
    return result;
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

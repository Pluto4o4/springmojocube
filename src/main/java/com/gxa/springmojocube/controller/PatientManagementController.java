package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.service.impl.PatientManagermentService;
import com.gxa.springmojocube.utils.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 患者管理
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 12:39
 */
@RestController
public class PatientManagementController {
  @Autowired private PatientManagermentService service;

  // 查找所有
  @GetMapping("/patientmanagerment/query")
  public Result queryAll() {
    List<Patient> reservations = this.service.queryAll();

    return new Result().ok(reservations);
  }

  // 根据id删除
  @PostMapping("/patientmanagerment/deletById")
  public Result deletById(@RequestBody Patient Patient) {
    this.service.deleteById(Patient);
    return new Result().ok();
  }

  // 添加
  @PostMapping("/patientmanagerment/add")
  public Result addById(@RequestBody Patient reservation) {
    this.service.add(reservation);
    return new Result().ok();
  }
  // 根据id获取信息
  @GetMapping("/patientmanagerment/selectById")
  public Result selectById(@RequestBody Patient reservation) {
    Patient newreservation = this.service.selectById(reservation);
    return new Result().ok(newreservation);
  }
  // 修改
  @PostMapping("/patientmanagerment/updateById")
  public Result updateById(@RequestBody Patient reservation) {
    this.service.updateById(reservation);
    return new Result().ok();
  }
  // 转交
  @PostMapping("/patientmanagerment/handOverById")
  public Result handOver(@RequestBody Patient Patient) {
    return new Result().error();
  }
  // 高级搜索
  @GetMapping("/patientmanagerment/searchById")
  public Result search(Patient Patient) {
    List<Patient> res = this.service.search(Patient);
    return new Result().ok(res);
  }
}

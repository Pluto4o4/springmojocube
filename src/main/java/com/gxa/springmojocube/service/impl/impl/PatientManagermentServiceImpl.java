package com.gxa.springmojocube.service.impl.impl;

import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.mapper.PatientManagermentMapper;
import com.gxa.springmojocube.service.impl.PatientManagermentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 患者管理实现类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 13:26
 */
@Service
public class PatientManagermentServiceImpl implements
    PatientManagermentService {
  @Autowired(required = false)
  private PatientManagermentMapper mapper;


  @Override
  public List<Patient> queryAll() {
    List<Patient> list=this.mapper.queryAll();
    return list;
  }

  @Override
  public void deleteById(Patient Patient) {
    this.mapper.deleteById(Patient);
  }

  @Override
  public void add(Patient reservation) {
    this.mapper.add(reservation);
  }

  @Override
  public Patient selectById(Patient reservation) {
    return this.mapper.selectById(reservation);
  }

  @Override
  public void updateById(Patient reservation) {
    this.mapper.updateById(reservation);
  }

  @Override
  public List<Patient> search(Patient Patient) {
    return this.mapper.search(Patient);
  }
}

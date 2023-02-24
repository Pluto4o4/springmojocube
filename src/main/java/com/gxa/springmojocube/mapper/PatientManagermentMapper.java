package com.gxa.springmojocube.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.springmojocube.entity.Patient;
import java.util.List;

public interface PatientManagermentMapper extends BaseMapper<Patient> {

  List<Patient> queryAll();

  int deleteById(Patient Patient);

  void add(Patient reservation);

  Patient selectById(Patient reservation);

  int updateById(Patient reservation);

}

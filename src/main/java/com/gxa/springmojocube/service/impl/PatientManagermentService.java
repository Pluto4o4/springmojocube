package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Patient;
import com.gxa.springmojocube.utils.Result;
import java.util.List;

public interface PatientManagermentService {

  List<Patient> queryAll();

  void deleteById(Patient Patient);

  void add(Patient reservation);

  Result selectById(Patient reservation);

  boolean updateById(Patient reservation);

}

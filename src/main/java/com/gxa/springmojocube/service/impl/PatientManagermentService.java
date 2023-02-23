package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Patient;
import java.util.List;

public interface PatientManagermentService {

  List<Patient> queryAll();

  void deleteById(Patient Patient);

  void add(Patient reservation);

  Patient selectById(Patient reservation);

  void updateById(Patient reservation);

  List<Patient> search(Patient Patient);
}

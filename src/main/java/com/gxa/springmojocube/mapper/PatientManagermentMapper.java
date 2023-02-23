package com.gxa.springmojocube.mapper;

import com.gxa.springmojocube.entity.Patient;
import java.util.List;

public interface PatientManagermentMapper {

  List<Patient> queryAll();

  void deleteById(Patient Patient);

  void add(Patient reservation);

  Patient selectById(Patient reservation);

  void updateById(Patient reservation);

  List<Patient> search(Patient Patient);
}

package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Drug;
import com.gxa.springmojocube.utils.Result;

public interface DrugService {
   Result addDrug(Drug drug);
   Result selectPage(Integer index,Integer size,String supplierName,String status);
   Result deleteDrug(String id);
   Result updateDrug(Drug drug);
}

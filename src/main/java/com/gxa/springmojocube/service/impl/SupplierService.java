package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Supplier;
import com.gxa.springmojocube.utils.Result;

public interface SupplierService {
   Result addSupplier(Supplier supplier);
   Result deleteSupplier(String id);
   Result updateSupplier(Supplier supplier);
   Result selectPage(Integer pageNumber, Integer pageSize,String supplierName,String type,String status);
}

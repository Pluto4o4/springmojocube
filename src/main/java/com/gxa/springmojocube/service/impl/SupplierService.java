package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.Supplier;
import com.gxa.springmojocube.utils.Result;
import io.swagger.models.auth.In;

public interface SupplierService {
   Result addSupplier(Supplier supplier);
   Result deleteSupplier(String id);
   Result updateSupplier(Supplier supplier);
   Result selectPage(Integer index, Integer size, String supplierName, String type, String status, String province, String address, String contacts);
   Result selectSupplierName(String supplierName);
}

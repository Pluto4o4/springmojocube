package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.controller.SupplierMoreController;
import com.gxa.springmojocube.entity.SupplierMore;
import com.gxa.springmojocube.utils.Result;

public interface SupplierMoreService {
   Result addSupplierMore(SupplierMore supplierMore);

   Result deleteSupplierMore(String id);

   Result getPage(Integer index, Integer size, String title, String phone, String contact, String status, String pic);

   Result updateSupplierMore(SupplierMore supplierMore);
}

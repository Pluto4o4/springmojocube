package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Supplier;
import com.gxa.springmojocube.service.impl.SupplierService;
import com.gxa.springmojocube.utils.Result;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/supplier")
public class SupplierController {

   @Resource
   SupplierService supplierService;
   @PostMapping("/add")
   public Result addSupplier(@RequestBody Supplier supplier){
      return supplierService.addSupplier(supplier);
   }

   @PostMapping("/delete")
   public Result deleteSupplier(@RequestParam("id") String id){
      return supplierService.deleteSupplier(id);
   }

   @PostMapping("/update")
   public Result updateSupplier(@RequestBody Supplier supplier){
      return supplierService.updateSupplier(supplier);
   }
   //分页查询
   @GetMapping("/page")
   public Result page(@RequestParam(defaultValue = "1") Integer index,
                      @RequestParam(defaultValue = "10") Integer size,
                      @RequestParam(required = false) String supplierName,
                      @RequestParam(required = false) String type,
                      @RequestParam(required = false) String status){
      return supplierService.selectPage(index,size,supplierName,type,status);
   }

   @GetMapping("/selectBySupplierName")
   public Result selectSupplierName(@RequestParam(required = false) String supplierName){
      return supplierService.selectSupplierName(supplierName);
   }
}

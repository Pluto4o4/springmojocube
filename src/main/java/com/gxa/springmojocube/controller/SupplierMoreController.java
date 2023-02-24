package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.SupplierMore;
import com.gxa.springmojocube.service.impl.SupplierMoreService;
import com.gxa.springmojocube.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/supplierMore")
public class SupplierMoreController {

   @Resource
   SupplierMoreService supplierMoreService;

   @PostMapping("/add")
   public Result addSupplierMore(@RequestBody SupplierMore supplierMore){
      return supplierMoreService.addSupplierMore(supplierMore);
   }

   @PostMapping("/delete")
   public Result deleteSupplierMore(String id){
      return supplierMoreService.deleteSupplierMore(id);
   }

   @GetMapping("/page")
   public Result getPage(@RequestParam(defaultValue = "1") Integer index,
                         @RequestParam(defaultValue = "10") Integer size,
                         @RequestParam(required = false) String title,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String contact,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String pic
                         ){

      return supplierMoreService.getPage(index,size,title,phone,contact,status,pic);
   }

   @PostMapping("/update")
   public Result updateSupplierMore(@RequestBody SupplierMore supplierMore){
      return supplierMoreService.updateSupplierMore(supplierMore);
   }
}

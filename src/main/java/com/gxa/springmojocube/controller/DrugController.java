package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Drug;
import com.gxa.springmojocube.service.impl.DrugService;
import com.gxa.springmojocube.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/drug")
public class DrugController {

   @Resource
   DrugService drugService;
   @PostMapping("/add")
   public Result addDrug(@RequestBody Drug drug){
      return drugService.addDrug(drug);
   }


   @PostMapping("/delete")
   public Result deleteDrug(@RequestParam String id){
      return drugService.deleteDrug(id);
   }

   @GetMapping("/page")
   public Result selectPage(@RequestParam(defaultValue = "1") Integer index,
                            @RequestParam(defaultValue = "10") Integer size,
                            @RequestParam(required = false) String drugName,
                            @RequestParam(required = false) String status){
      return drugService.selectPage(index,size,drugName,status);
   }

   @PostMapping("/update")
   public Result updateDrug(@RequestBody Drug drug){
      return drugService.updateDrug(drug);
   }

   @GetMapping("/selectByDrugName")
   public Result selectDrugName(@RequestParam(required = false) String drugName){
      return drugService.selectDrugName(drugName);
   }
}

package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.Qo.DiagnosisListQo;
import com.gxa.springmojocube.entity.Qo.DiagnosisQo;
import com.gxa.springmojocube.service.impl.DiagnosisService;
import com.gxa.springmojocube.utils.DiagnosisExcelUtils;
import com.gxa.springmojocube.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiaFengYi
 * @date 2023/02/23/20:14
 * @description
 **/
@RestController
@Slf4j
@RequestMapping("/diagnosis")
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiagnosisExcelUtils diagnosisExcelUtils;
    @GetMapping("/list")
    public Result queryList(@RequestParam("cur") String cur,@RequestParam("size")String size,
                            @RequestParam("name")String name,@RequestParam("status")String status){
        return diagnosisService.diagnosisList(cur,size,name,status);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id){
        return diagnosisService.delect(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody DiagnosisQo qo){
        return diagnosisService.add(qo);
    }

    @PostMapping("/update")
    public Result update(@RequestBody DiagnosisQo qo){
        return  diagnosisService.update(qo);
    }
    @GetMapping("/info")
    public Result getInfo(){
        return  diagnosisService.diagnosisInfo();
    }

    @GetMapping("/excel")
    public Result getExcel(){
       return diagnosisExcelUtils.simpleWrite();
    }
}

package com.gxa.springmojocube.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.gxa.springmojocube.entity.DiagnosisExcel;
import com.gxa.springmojocube.service.impl.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author JiaFengYi
 * @date 2023/02/24/19:43
 * @description
 **/
@Component
public class DiagnosisExcelUtils {
    @Autowired
    private DiagnosisService diagnosisService;

    public Result simpleWrite() {
        try{
            String fileName =  "D:\\excel\\诊断系统报表excel" + System.currentTimeMillis() + ".xlsx";
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write(fileName, DiagnosisExcel.class)
                    .sheet("模板")
                    .doWrite(() -> {
                        // 分页查询数据
                        return diagnosisService.putOutExcel();
                    });
        }catch (Exception e){
            return new Result().error();
        }
        return new Result().ok();

    }

}

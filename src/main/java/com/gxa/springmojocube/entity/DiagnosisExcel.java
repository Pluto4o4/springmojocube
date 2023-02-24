package com.gxa.springmojocube.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author JiaFengYi
 * @date 2023/02/24/19:40
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DiagnosisExcel {

    @ExcelProperty("id编号")
    private String id;
    @ExcelProperty("标题")
    private String title;
    @ExcelProperty("类型")
    private String type;
    @ExcelProperty("用户名")
    private String userName;
    @ExcelProperty("部门")
    private String department;
    @ExcelProperty("床位号")
    private String bedNumber;
    @ExcelProperty("负责人")
    private String pic;
    @ExcelProperty("医药费")
    private String price;
    @ExcelProperty("创建时间")
    private String createTime;
    @ExcelProperty("药品")
    private String drug;
    @ExcelProperty("是否支付")
    private String payStatus;
    @ExcelProperty("状态")
    private String status;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("地址")
    private String address;
}

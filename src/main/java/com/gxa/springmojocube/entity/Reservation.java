package com.gxa.springmojocube.entity;

import lombok.Data;

@Data
public class Reservation {
    private Integer id;
    private String doctorName;
    private Dept dept;//部门
    private Title title;//职称
    private int day;//天数
    private int size;//最大人数
    private int status;//0 可预约 1 不可预约
}

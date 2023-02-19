package com.gxa.springmojocube.entity;

import lombok.Data;

/**
 * 预约
 *
 * @author Mr.Xu/Pluto404
 * @since 9:53 2023/2/19
 * @version V1.0
 */
@Data
public class Reservation {
  private Integer id;
  private String doctorName;
  private Dept dept; // 部门
  private Title title; // 职称
  private int day; // 天数
  private int size; // 最大人数
  private int status; // 0 可预约 1 不可预约
}

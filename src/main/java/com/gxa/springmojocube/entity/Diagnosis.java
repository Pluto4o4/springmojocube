package com.gxa.springmojocube.entity;

import lombok.Data;

/**
 * 患者类2
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 13:41
 */
@Data
public class Diagnosis {
 private String id;
 private String title;
 private String type;
 private String user_name;
  private String department;
  private String bed_number;
  private String pic;
  private String price;
  private String create_time;
  private String drugs_number;
  private String pat_statsus;
  private String status;
  private String province;
  private String address;
  private String phone;
}

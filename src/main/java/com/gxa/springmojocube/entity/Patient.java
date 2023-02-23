package com.gxa.springmojocube.entity;

import lombok.Data;

/**
 * 患者实体类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 10:23
 */
@Data
public class Patient {
  private String id;

  private String user_name;
  private String user_sex;
  private String user_age;
  private String phone;
  private String identity;
  private String id_card;
  private String province;
  private String adress;
  private String user_appoint;

  private String create_time;
  private String day;
}

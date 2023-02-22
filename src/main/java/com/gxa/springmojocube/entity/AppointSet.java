package com.gxa.springmojocube.entity;

import lombok.Data;

/**
 * 设置类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 11:52
 */
@Data
public class AppointSet {
  private String id;
  private String user_appoint;
  private String department;
  private String occupation;
  private String appoint_time;
  private String surplus;
  private String status;
}

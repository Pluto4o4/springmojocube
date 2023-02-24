package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
  private String userAppoint;

  private String department;
  private String occupation;

  private String appoint_time;
  private String appointTime;

  private String surplus;
  private String status;
  @TableField(exist = false)
  private String index;
  @TableField(exist = false)
  private String size;

  public void setUserAppoint(String userAppoint) {
    this.user_appoint = userAppoint;
  }

  public void setAppointTime(String appointTime) {
    this.appoint_time = appointTime;
  }
}

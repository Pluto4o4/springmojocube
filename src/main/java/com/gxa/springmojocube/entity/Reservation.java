package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 预约实体类
 *
 * @author Mr.Xu/Pluto404
 * @since 9:53 2023/2/19
 * @version V1.0
 */
@Data
@TableName("appoint")
public class Reservation {

  @TableId(value = "id", type = IdType.AUTO)
  private String id;
  private String user_name;
  private String userName;
  private String user_sex;
  private String userSex;

  private String user_age;
  private String userAge;
  private String phone;

  public void setUserName(String userName) {
    this.user_name = userName;
  }

  public void setUserSex(String userSex) {
    this.user_sex = userSex;
  }

  public void setUserAge(String userAge) {
    this.user_age = userAge;
  }

  public void setUserAppoint(String userAppoint) {
    this.user_appoint = userAppoint;
  }

  public void setCreateTime(String createTime) {
    this.create_time = createTime;
  }

  public void setAppointTime(String appointTime) {
    this.appoint_time = appointTime;
  }

  private String address;
  private String status; //  状态0为禁用，1为启用
  private String user_appoint; // 预约人
  private String userAppoint; // 预约人
  private String department; // 部门
  private String create_time; // 创建时间
  private String createTime; // 创建时间
  private String appoint_time; // 预约时间
  private String appointTime; // 预约时间
  @TableField(exist = false)
  private String index;
  @TableField(exist = false)
  private String size;
}

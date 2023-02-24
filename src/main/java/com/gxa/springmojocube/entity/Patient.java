package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

  @TableId(value = "id", type = IdType.AUTO)
  private String id;
  private String user_name;
  private String userName;
  private String user_sex;
  private String userSex;
  private String user_age;
  private String userAge;
  private String phone;
  private String identity;
  private String id_card;
  private String idCard;
  private String province;
  private String adress;
  private String user_appoint;
  private String userAppoint;

  private String create_time;
  private String createTime;
  private String day;

  public void setUserName(String userName) {
    this.user_name = userName;
  }

  public void setUserSex(String userSex) {
    this.user_sex = userSex;
  }

  public void setUserAge(String userAge) {
    this.user_age = userAge;
  }

  public void setIdCard(String idCard) {
    this.id_card = idCard;
  }

  public void setUserAppoint(String userAppoint) {
    this.user_appoint = userAppoint;
  }

  public void setCreateTime(String createTime) {
    this.create_time = createTime;
  }

  private String status;
  @TableField(exist = false)
  private String index;
  @TableField(exist = false)
  private String size;
}

package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 预约实体类
 *
 * @author Mr.Xu/Pluto404
 * @since 9:53 2023/2/19
 * @version V1.0
 */
@Data
public class Reservation {

  @TableId(value = "id", type = IdType.AUTO)
  private String id;
  private String user_name;
  private String user_sex;
  private String user_age;
  private String phone;
  private String address;
  private String status; //  状态0为禁用，1为启用
  private String user_appoint; // 预约人
  private String department; // 部门
  private String create_time; // 创建时间
  private String appoint_time; // 预约时间
  private String index;
  private String size;
}

package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 患者类2
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/23 13:41
 */
@Data
@TableName("diagnosis")
public class Diagnosis {
 private String id;
 @TableField("title")
 private String title;
 @TableField("type")
 private String type;
 @TableField("user_name")
 private String userName;
 @TableField("department")
  private String department;
 @TableField("bed_number")
  private String bedNumber;
 @TableField("pic")
  private String pic;
 @TableField("price")
  private String price;
 @TableField("create_time")
  private String createTime;
 @TableField("drug")
  private String drug;
 @TableField("pay_status")
  private String payStatus;
 @TableField("status")
  private String status;
 @TableField("province")
  private String province;
 @TableField("address")
  private String address;

}

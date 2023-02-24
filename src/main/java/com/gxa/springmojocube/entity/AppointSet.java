package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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


  @TableId(value = "id", type = IdType.AUTO)
  private String id;
  private String user_appoint;
  private String department;
  private String occupation;
  private String appoint_time;
  private String surplus;
  private String status;
  private String index;
  private String size;
}

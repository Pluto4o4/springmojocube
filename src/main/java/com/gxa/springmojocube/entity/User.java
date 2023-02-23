package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 9:12
 */
@Data
@TableName("manger")
public class User {
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;
  private String name;
  private String pwd;
  private Integer status;  //状态：0正常，1禁用
  private String email;
  @TableField(exist = false)
  private String code;
}

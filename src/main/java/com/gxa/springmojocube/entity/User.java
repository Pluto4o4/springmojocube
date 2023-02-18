package com.gxa.springmojocube.entity;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 9:12
 */
@Data
public class User {
  private Integer id;
  private String name;
  private String pwd;
  private Integer status;  //状态：0正常，1禁用
}

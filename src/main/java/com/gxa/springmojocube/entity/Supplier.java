package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Supplier {
   @TableId(value = "id", type = IdType.AUTO)
   private Integer id;
   private String supplierName;
   private Integer type;
   private Integer status;
   private Integer employeesNumber;
   private String province;
   private String address;
   private String contacts;
   private String productNumber;
}

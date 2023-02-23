package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Drug {
   @TableId(value = "id",type = IdType.AUTO)
   private Integer id;
   private String drugName;
   private String type;
   private String price;
   private Integer drugNumber;
   private String company;
   private String pic;
   private String supplierName;
   private Integer status;
}

package com.gxa.springmojocube.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
public class SupplierMore {
   @TableId(value = "id",type = IdType.AUTO)
   private Integer id;
   private String phone;
   private String title;
   private String customer;
   private String contact;
   private String status;
   private String pic;
   private String moreTime;
   private Date nextMoreTime;
   private String createTime;
}

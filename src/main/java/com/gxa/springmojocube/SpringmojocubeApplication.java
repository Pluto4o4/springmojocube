package com.gxa.springmojocube;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.gxa.springmojocube.mapper")
//@MapperScan("com.gxa.springmojocube.mapper")//扫描指定mapper接口
public class SpringmojocubeApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringmojocubeApplication.class, args);
  }

}

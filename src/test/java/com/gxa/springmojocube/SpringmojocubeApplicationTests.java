package com.gxa.springmojocube;

import com.gxa.springmojocube.utils.DiagnosisExcelUtils;
import com.gxa.springmojocube.utils.cache.MyCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringmojocubeApplicationTests {

  @Test
  void contextLoads() {
  }


  @Resource
  MyCache myCache;
  @Autowired
  private DiagnosisExcelUtils excelUtils;
  @Test
  void test1(){
    myCache.put("1","1",10);
    myCache.put("2","2",10);
    myCache.put("3","3",10);
    myCache.put("4","4",10);
    myCache.put("5","5",10);
    myCache.put("6","6",10);
    myCache.put("7","7",10);
    myCache.put("8","8",10);
    try {
      Thread.sleep(10000);
      System.err.println("退出");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  void Excel(){
    excelUtils.simpleWrite();
  }

}

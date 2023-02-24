package com.gxa.springmojocube;

import com.gxa.springmojocube.utils.cache.MyCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringmojocubeApplicationTests {

  @Test
  void contextLoads() {
  }


  @Resource
  MyCache myCache;
  @Test
  void test1(){
    new MyCache();
    System.err.println(System.currentTimeMillis());
    myCache.put("1","1",2000000000);
    myCache.put("2","2",15000);
    myCache.put("3","3",1000);
    myCache.put("4","4",90);
    myCache.put("5","5",70);
    myCache.put("6","6",50);
    myCache.put("7","7",30);
    myCache.put("8","8",10);
    new Thread(()->{
      System.err.println("234234");
      try {
        Thread.sleep(123);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"fjdis").start();
    try {
      Thread.sleep(100000);
      System.err.println("退出");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

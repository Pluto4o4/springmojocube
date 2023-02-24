package com.gxa.springmojocube;

import com.gxa.springmojocube.utils.cache.DelayTask;
import com.gxa.springmojocube.utils.cache.MyCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringmojocubeApplicationTests {

  @Test
  void contextLoads() {
  }


  @Resource
  MyCache myCache;
  @Test
  void test1() throws InterruptedException {
    new MyCache();
    System.err.println(System.currentTimeMillis());
    DelayTask<? extends Runnable> tast1=new DelayTask(new Runnable() {
      @Override
      public void run() {
        System.err.println(System.currentTimeMillis());
      }
    }, null, 5L, TimeUnit.SECONDS);
    DelayTask<? extends Runnable> tast4=new DelayTask(new Runnable() {
      @Override
      public void run() {
        System.err.println(System.currentTimeMillis());
      }
    }, null, 1L, TimeUnit.SECONDS);
    DelayTask<? extends Runnable> tast2=new DelayTask(new Runnable() {
      @Override
      public void run() {
        System.err.println(System.currentTimeMillis());
      }
    }, null, 15L, TimeUnit.SECONDS);
    DelayTask<? extends Runnable> tast3=new DelayTask(new Runnable() {
      @Override
      public void run() {
        System.err.println(System.currentTimeMillis());
      }
    }, null, 25L, TimeUnit.SECONDS);

    DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
    //add 和 put 后面都是调用的offer方法，内部使用了ReentrantLock
    //delayQueue.put();
    delayQueue.add(tast1);
    delayQueue.add(tast2);
    delayQueue.add(tast3);
    delayQueue.add(tast4);

    System.out.println("订单延迟队列开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    while (delayQueue.size() != 0) {
      /**
       * 取队列头部元素是否过期
       */
      //DelayQueue的put/add方法是线程安全的，因为put/add方法内部使用了ReentrantLock锁进行线程同步。
      // DelayQueue还提供了两种出队的方法 poll() 和 take() ，
      // poll() 为非阻塞获取，没有到期的元素直接返回null；
      // take() 阻塞方式获取，没有到期的元素线程将会等待。
      DelayTask task = delayQueue.poll();
      if (task != null) {
        System.out.format("数据:{%s}被取消, 删除时间:{%s}\n", task.getData(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      }
      Thread.sleep(1000);
    }


  }

}

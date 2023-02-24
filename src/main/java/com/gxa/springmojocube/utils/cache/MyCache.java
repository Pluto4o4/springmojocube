package com.gxa.springmojocube.utils.cache;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newCachedThreadPool;

@Component
public class MyCache {

   private static ExecutorService executor;
   private static DelayQueue<DelayTask<?>> delayQueue;

//   @PostConstruct
//   @SuppressWarnings({"PMD.AvoidManuallyCreateThreadRule", "PMD.ThreadPoolCreationRule"})
//   public void init() {
   static {
      executor = newCachedThreadPool();
      delayQueue = new DelayQueue<>();

      //后台线程,监听延时队列
      Thread daemonThread = new Thread(()->{execute();});
      daemonThread.setName("本地延时队列-DelayQueueMonitor");
      daemonThread.start();
   }

   private static void execute() {
      while (true) {
         try {
            // 从延时队列中获取任务,如果队列为空, take 方法将会阻塞在这里
            DelayTask<?> delayMessage = delayQueue.take();
//            System.err.println("获取任务"+delayMessage.getDelay();
            Runnable task = (Runnable) delayMessage.getTask();

            if (null == task) {
               continue;
            }
            // 提交到线程池执行 task
            executor.execute(task);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   /**
    * 添加任务
    *
    * @param task 待延迟执行的任务
    * @param time 延时时间
    * @param unit 时间单位
    */
   public void put(Runnable task, long time, TimeUnit unit) {
      // 获取延时时间
      long timeout = TimeUnit.SECONDS.convert(time, unit);
      // 将任务封装成实现 Delayed 接口的消息体
      DelayTask<? extends Runnable> delayMessage = new DelayTask<>( task,timeout, null);
      // 将消息体放到延时队列中
      delayQueue.put(delayMessage);
   }

   static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

   public void put(String k, Object v) {
      map.put(k, v);
      this.put(() -> map.remove(k), 1000, TimeUnit.SECONDS);
   }

   public void put(String k, Object v,long time) {

      // 获取延时时间
//      long timeout = TimeUnit.SECONDS.convert(time, TimeUnit.SECONDS);
      if(map.containsKey(k)){
         DelayTask<? extends Runnable> delayTask=(DelayTask)map.get(k);
         delayTask.setTime(time);
         return;
      }

      // 将任务封装成实现 Delayed 接口的消息体
      DelayTask<? extends Runnable> delayMessage = new DelayTask<>(new Runnable() {
         @Override
         public void run() {
            Object o = map.get(k);

            System.err.println("移除"+(DelayTask<? extends Runnable>)map.get(k)+System.currentTimeMillis());
            map.remove(k);
         }
      }, time, v);
      map.put(k,delayMessage);
      // 将消息体放到延时队列中
      delayQueue.put(delayMessage);
   }

   public Object get(String k) {
      return map.get(k);
   }

   public boolean containsKey(String k) {
      return map.containsKey(k);
   }

   public boolean remove(String k) {
      if(map.containsKey(k)){
         DelayTask<? extends Runnable> delayTask=(DelayTask)map.get(k);
         delayQueue.remove(delayTask);
         map.remove(k);
         return true;
      }
      return false;
   }

}


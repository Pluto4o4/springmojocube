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

   private ExecutorService executor;
   private DelayQueue<DelayTask<?>> delayQueue;
   @PostConstruct
   @SuppressWarnings({"PMD.AvoidManuallyCreateThreadRule", "PMD.ThreadPoolCreationRule"})
   public void init() {
      executor = newCachedThreadPool();
      delayQueue = new DelayQueue<>();

      //后台线程,监听延时队列
      Thread daemonThread = new Thread(this::execute);
      daemonThread.setName("本地延时队列-DelayQueueMonitor");
      daemonThread.start();
   }

   private void execute() {
      while (true) {
         try {
            // 从延时队列中获取任务,如果队列为空, take 方法将会阻塞在这里
            DelayTask<?> delayMessage = delayQueue.take();
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
      long timeout = TimeUnit.NANOSECONDS.convert(time, unit);
      // 将任务封装成实现 Delayed 接口的消息体
      DelayTask<? extends Runnable> delayMessage = new DelayTask<>(timeout, task,null);
      // 将消息体放到延时队列中
      delayQueue.put(delayMessage);
   }

   /**
    * 删除任务
    */
   public boolean removeTask(Runnable task) {
      return delayQueue.remove(task);
   }




      static ConcurrentHashMap<String,Object> map=new ConcurrentHashMap<>();
      public Object call() throws Exception {
         return null;
      }
      public static void put(String k,Object v,Long times){


         map.put(k,v);
      }
      public static Object get(String k){
         return map.get(k);+
      }
      public static boolean containsKey(String k){
         return  map.containsKey(k);
      }
      public static void remove(String string){
         map.remove(string);
      }

}

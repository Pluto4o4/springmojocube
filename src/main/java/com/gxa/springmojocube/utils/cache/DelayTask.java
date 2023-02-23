package com.gxa.springmojocube.utils.cache;


import lombok.Data;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
@Data
public class DelayTask<T> implements Delayed {
   private Long time;//到点执行
   private T task;//任务
   private Object data;

   public DelayTask(T task, Long time,Object data) {
      this.time = time+System.currentTimeMillis();
      this.task = task;
      this.data = data;
   }

   public long getDelay(TimeUnit unit) {
      return unit.convert(this.time-System.currentTimeMillis()/1000, TimeUnit.SECONDS);
   }

   @Override
   public int compareTo(Delayed delayed) {
      // 过期时间长的放置在队列尾部
      if (this.getDelay(TimeUnit.SECONDS) > getDelay(TimeUnit.SECONDS)) {
         return 1;
      }
      // 过期时间短的放置在队列头
      if (this.getDelay(TimeUnit.SECONDS) < getDelay(TimeUnit.SECONDS)) {
         return -1;
      }
      return 0;

   }

   public T getTask() {
      return this.task;
   }

}

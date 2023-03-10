package com.gxa.springmojocube.utils.cache;


import lombok.Data;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
@Data
public class DelayTask<T> implements Delayed {
   private Long time;//到点执行
   private T task;//任务
   private Object data;

   public DelayTask(T task, Object data,Long time,TimeUnit unit) {
      this.time = System.currentTimeMillis()+(time>0?unit.toMillis(time):0);
      this.task = task;
      this.data = data;
   }

   public long getDelay(TimeUnit unit) {
      return time-System.currentTimeMillis();
   }

   @Override

   public int compareTo(Delayed delayed) {
      // 过期时间长的放置在队列尾部
      if (this.getDelay(TimeUnit.MILLISECONDS) > getDelay(TimeUnit.MILLISECONDS)) {
         return 1;
      }
      // 过期时间短的放置在队列头
      if (this.getDelay(TimeUnit.MILLISECONDS) < getDelay(TimeUnit.MILLISECONDS)) {
         return -1;
      }
      return 0;

   }

   public T getTask() {
      return this.task;
   }

}

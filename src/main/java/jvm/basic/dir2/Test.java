package jvm.basic.dir2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {



    }

   static  class  AA extends   ThreadPoolExecutor{

       public AA(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
           super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
       }

       public AA(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
           super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
       }

       public AA(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
           super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
       }

       public AA(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
           super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
       }


       @Override
       protected void beforeExecute(Thread t, Runnable r) {
           super.beforeExecute(t, r);
       }
   }

}

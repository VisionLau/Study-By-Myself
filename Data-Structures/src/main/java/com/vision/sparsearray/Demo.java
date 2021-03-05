package com.vision.sparsearray;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //ExecutorService pool =Executors.newFixedThreadPool(10);
        //ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        //ExecutorService pool =Executors.newCachedThreadPool();
       // ExecutorService pool =Executors.newWorkStealingPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            });

        }
    }

}

class Demo02 implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}

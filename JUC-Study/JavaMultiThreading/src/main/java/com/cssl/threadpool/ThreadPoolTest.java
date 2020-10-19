package com.cssl.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.execute(new ThreadPool());
        executorService.execute(new ThreadPool());
        executorService.execute(new ThreadPool());
        executorService.shutdown();
    }
}
class ThreadPool implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}



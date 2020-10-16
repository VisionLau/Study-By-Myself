package com.cssl.test;

import java.util.concurrent.*;

/**
 *
 * */
public class TestCallable  implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        //TestDemo testDemo=new TestDemo();
       // testDemo.runMethod();
        return true;
    }
    public static void main(String[] args){
        TestCallable testCallable1=new TestCallable();
        TestCallable testCallable2=new TestCallable();
        TestCallable testCallable3=new TestCallable();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Future<Boolean> submit1 = executorService.submit(testCallable1);
        Future<Boolean> submit2 = executorService.submit(testCallable2);
        Future<Boolean> submit3 = executorService.submit(testCallable3);
        try {
            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

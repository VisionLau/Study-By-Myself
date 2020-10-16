package com.cssl.test;

public class TickesTest implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i >=0; i--) {
            System.out.println(Thread.currentThread().getName()+"获得了第"+i+"张票");
        }
    }
    public static void main(String[] args){
        new Thread(new TickesTest(),"普通用户").start();
        new Thread(new TickesTest(),"黄牛党").start();
    }
}

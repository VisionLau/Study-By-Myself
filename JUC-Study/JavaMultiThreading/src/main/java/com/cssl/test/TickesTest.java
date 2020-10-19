package com.cssl.test;

import jdk.nashorn.internal.ir.ReturnNode;

public class TickesTest implements Runnable{
    private int tickNum=100;
    private boolean flag=true;
    @Override
    public  void run() {
        while (flag){
            buy();
        }
    }
    public static void main(String[] args){
        TickesTest tickesTest = new TickesTest();
         new Thread(tickesTest, "黄牛党").start();
        new Thread(tickesTest,"普通用户").start();
    }
    private synchronized void buy()  {
        if(tickNum<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"获得了第"+tickNum--+"张票");
    }
}

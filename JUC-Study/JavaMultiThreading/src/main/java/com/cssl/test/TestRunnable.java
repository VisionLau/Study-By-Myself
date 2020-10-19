package com.cssl.test;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"说HelloWorld");
    }
    public static void main(String[] args){
        new Thread(new TestRunnable()).start();
        new Thread(new TestRunnable()).start();
    }
}

package com.cssl.test;

public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"说HelloWorld");
    }
    public static void main(String[] args){
        new TestThread().start();
        new TestThread().start();
    }
}

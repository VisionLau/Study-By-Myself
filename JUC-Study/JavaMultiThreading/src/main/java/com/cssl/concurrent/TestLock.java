package com.cssl.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {
    private int tickNum = 100;
    private boolean flag = true;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            try {
                lock.lock();
                buy();
            }finally {
                lock.unlock();
            }
        }
    }
    private void buy() {
        if (tickNum <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "获得了第" + tickNum-- + "张票");
    }

    public static void main(String[] args) {
        TestLock tickesTest = new TestLock();
        new Thread(tickesTest, "黄牛党").start();
        new Thread(tickesTest, "普通用户").start();
    }
}


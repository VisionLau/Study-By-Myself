package com.cssl.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;

public class TestCOWA {
    public static void main(String[] args){
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            });
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}

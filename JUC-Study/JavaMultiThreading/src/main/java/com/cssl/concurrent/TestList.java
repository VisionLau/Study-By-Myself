package com.cssl.concurrent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(list.size());
    }
}

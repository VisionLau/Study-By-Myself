package com.cssl.test2;

public class ThreadState {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state=thread.getState();
        System.out.println(state);
        while (state!=Thread.State.TERMINATED){
            state= thread.getState();
            System.out.println(state);
        }
    }
}

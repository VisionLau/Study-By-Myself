package com.cssl.test;

public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(whoIsWinner(i)){
                break;
            }
        }
    }

    private boolean  whoIsWinner(int step){
        if(step>=100){
            winner=Thread.currentThread().getName();
            System.out.println("winner is"+winner);
            return true;
        }{
            System.out.println(Thread.currentThread().getName()+"-->跑了"+step+"步");
        }
        return false;
    }

    public static void main(String[] args){
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}

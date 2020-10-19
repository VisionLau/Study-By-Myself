package com.cssl.communication;

public class TestPC2 {
    public static void main(String[] args){
        TV tv = new TV();
        new Thread(new Actor(tv)).start();
        new Thread(new Audience(tv)).start();
    }
}
class Actor implements Runnable{
    private TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i <=24; i++) {
            if(i%3==0){
                tv.show("黑袍纠察队");
            }else if(i%3==1){
                tv.show("高奇堡人");
            }else{
                tv.show("权力的游戏");
            }
        }
    }
}
class Audience implements  Runnable{
    private TV tv;

    public Audience(TV tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 24; i++) {
            tv.watch();
        }
    }
}

class TV{
    String show;
    boolean flag=true;
    public synchronized void show(String show){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+show);
        this.notifyAll();
        this.show=show;
        this.flag=!flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了"+show);
        this.notifyAll();
        this.flag=!flag;
    }
}
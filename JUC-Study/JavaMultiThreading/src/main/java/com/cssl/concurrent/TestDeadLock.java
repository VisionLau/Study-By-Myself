package com.cssl.concurrent;

public class TestDeadLock {
    public static void main(String[] args){
        new Thread(new MakeUp(1,"我")).start();
        new Thread(new MakeUp(2,"你")).start();
    }
}

class  MakeUp implements Runnable{
    static Lips lips=new Lips();
    static Mirror mirror=new Mirror();
    int choice;
    String name;
    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void makeup() throws InterruptedException {
        if(choice==1){
            synchronized (lips){
                System.out.println(this.name+"获得了口红");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.name+"获得了口红");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.name+"获得了镜子");
                Thread.sleep(1000);
            }
            synchronized (lips){
                System.out.println(this.name+"获得了口红");
            }
        }

    }
}

class Lips{
}
class Mirror{
}

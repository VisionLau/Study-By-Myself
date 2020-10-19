package com.cssl.communication;

public class TestPC {
    public static void main(String[] args){
        Buffer buffer=new Buffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}

//生产者线程
class Producer implements Runnable{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 11; i++) {
            buffer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者线程
class Consumer implements Runnable{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 11; i++) {
            buffer.pop();
            System.out.println("消费了"+i+"只鸡");
        }
    }
}
//商品类
class Chicken{
    private int id;
    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class Buffer{
    Chicken[] chickens=new Chicken[10];
    int count=0;
    public synchronized  void push(Chicken chicken){
        if(count ==chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count]=chicken;
        count++;
        this.notifyAll();
    }
    public synchronized Chicken pop(){
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notifyAll();
        return  chickens[count];
    }
}

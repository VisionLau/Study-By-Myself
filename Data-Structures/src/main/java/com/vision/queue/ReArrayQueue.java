package com.vision.queue;

public class ReArrayQueue {
    private int maxSize; //队列长度
    private int rear;//队列尾部
    private int front;//队列头
    private int[] array;//存储数组

    //初始化队列
    public ReArrayQueue(int queueMaxSize){
        maxSize=queueMaxSize;
        rear=-1;
        front=-1;
        array=new int[queueMaxSize];
    }
    //判断队列是否已满
    private boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否是空
    private boolean isEmpty(){
        return rear==front;
    }
    //添加队列
    public void addQueueEle(int ele){
        if(isFull()){
            System.out.println("队列已满");
        }
        //防止索引越界 必须+1
        rear++;
        array[rear]=ele;
    }
    //获取队列元素
    public int getQueueEle(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return array[front];
    }
    //获取队列头
    public int getQueueHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return array[front];
    }
    //展示队列
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d \t",i,array[i]);
        }
    }
}

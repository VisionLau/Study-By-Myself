package com.vision.queue;

public class CircleQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int[] array;

    public CircleQueue(int queueMaxSize) {
        maxSize = queueMaxSize;
        array = new int[queueMaxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int ele) {
        System.err.println(":::::"+rear);
        if (isFull()) {
            System.out.println("抱歉队列已满");
            return;
        }
        array[rear] = ele;
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }

        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //展示队列
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }
        for (int i = front; i < getEleCount(); i++) {
            System.out.printf("array[%d]=%d\t", i%maxSize, array[i%maxSize]);
        }
    }

    //获取队列头
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }
        return array[front];
    }

    public int getEleCount(){
        return (rear+maxSize-front)%maxSize;
    }
}

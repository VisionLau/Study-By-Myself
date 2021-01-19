package com.vision.queue;

public class ArrayQueue {
     private int maxSize;//队列的最大长度
     private int front;//队列头
     private int rear;//队列尾
     private int[] array;//储存队列数组

    /**
     * 初始化队列
     * @param queueMaxSize  队列最大长度
     */
     public ArrayQueue(int queueMaxSize){
         maxSize=queueMaxSize;
         front=-1;//队列初始化时 默认为空  所以队列头和尾都为-1
         rear=-1;
         array=new int[queueMaxSize];
     }

    //判断队列是否已满
     public boolean isFull(){
         return rear==maxSize-1;
     }

    //判断是否为空
     public boolean isEmpty(){
         return front==rear;
     }

    /**
     * 添加队列
     * @param ele  添加队列的元素
     */
     public void addQueue(int ele){
         if(isFull()){
             System.out.println("抱歉队列 已满");
             return;
         }
         rear++;//队列尾后移
         array[rear]=ele;//给队列数组添加数据
         //System.out.println(isFull());
         //System.err.printf("maxsize=%d,rear=%d  \n",maxSize,rear);
     }

     public int getQueue(){
         if(isEmpty()){
             throw new RuntimeException("队列为空！！");
         }
         front++;//取出队列头需要后移
         return array[front];//返回队列信息  先进先出
     }

     //展示队列
     public void showQueue(){
         if(isEmpty()){
             throw new RuntimeException("队列为空！！");
         }
         for (int i = 0; i < array.length; i++) {
             System.out.printf("array[%d]=%d\t",i,array[i]);
         }
     }

     //获取队列头
     public int getHead(){
         if(isEmpty()){
             throw new RuntimeException("队列为空！！");
         }
         return array[front+1];
     }
}

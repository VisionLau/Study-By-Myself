package com.vision.queue;

public class CircleQueue {
    private int maxSize;//队列长度
    private int rear;//尾元素  指向最后最后一个元素的后一个元素
    private int front;//头元素  指向第一个元素
    private int[] array;//存储的下标

    /**
     * 初始话队列  rear和front有默认值 这里就不赋值了
     * @param queueMaxSize  队列长度但实际可存储数据的个数为maxSize-1  我们有个约定
     */
    public CircleQueue(int queueMaxSize) {
        maxSize = queueMaxSize;
        array = new int[queueMaxSize];
    }

    //判断是否队列已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     *添加进队列
     * @param ele 需要添加的元素
     */
    public void addQueue(int ele) {
        if (isFull()) {
            System.out.println("抱歉队列已满");
            return;
        }
        //直接赋值即可
        array[rear] = ele;
        /*
        * 我们需要知道rear前面是否有空的空间
         *所以必须取模 否则无法实现环形
         * 假设maxSize为3  array[2]就是我们的约定  当rear指向这个下标时  那么约定应该到array[0]
         * 约定是动态变化的
         **/
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }
        /**
         * 取值 我们就要分三步了
         * 1. 将当前front存储到临时变量中 （如是第一次取 那么front就为0 临时变量的值应该为array[0]）
         * 2. 对front也要进行取模的运算
         *      假设 maxSize=3 队列已满 我们先取出一个  那么这个值就是 array[0] 下一次应该就是array[1]
         *      那么在下次呢？ 通过（front+1）%maxSize动态获取front就可以了
         * 3. 返回临时变量
         * */
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //展示队列
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }
        for (int i = front; i <front+ getEleCount(); i++) {
            //i%maxSize 防止i超过数组的大小
            System.out.printf("array[%d]=%d\t", i%maxSize, array[i%maxSize]);
        }
    }

    //获取队列头
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！！");
        }
        //直接返回即可
        return array[front];
    }

    public int getEleCount(){
        //动态获取当前队列有效的元素个数
        return (rear+maxSize-front)%maxSize;
    }
}

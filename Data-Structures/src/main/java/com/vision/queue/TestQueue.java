package com.vision.queue;

import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args){
       // ArrayQueue arrayQueue=new ArrayQueue(3);
        CircleQueue arrayQueue=new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("请选择业务：");
            System.out.print("a(添加队列)\t");
            System.out.print("g(取出队列)\t");
            System.out.print("s(展示队列)\t");
            System.out.print("h(获取队列头)\t");
            String input=scanner.next();
            switch (input){
                case "a":
                    System.out.println("请输入添加进队列的值：");
                    int num=scanner.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case "g":
                    try{
                        int  ele=arrayQueue.getQueue();
                        System.out.println("取出的数据为 "+ele);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try{
                        arrayQueue.showQueue();
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try{
                        System.out.println("队列头为："+arrayQueue.getHead());
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

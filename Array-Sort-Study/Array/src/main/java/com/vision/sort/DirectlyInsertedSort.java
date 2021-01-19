package com.vision.sort;

import java.util.Arrays;

public class DirectlyInsertedSort {
    /**
     * 直接插入算法排序思想如下
     * 我们从下标为1的元素开始，将其与前一位元素进行比较
     * 如果比他小，将两个元素互换位置即可
     * */
    public static void main(String[] args){
        int []array={2,5,4,65,32,4,3,1,0};
        System.out.println("未排序前的结果为："+Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            while(i>0&&array[i-1]<array[i]){
                int center=array[i-1];
                array[i-1]=array[i];
                array[i]=center;
                i--;
            }
        }

        System.out.println("通过直接插入排序后结果为："+ Arrays.toString(array));
    }
}

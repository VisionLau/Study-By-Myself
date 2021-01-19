package com.vision.sort;

import java.util.Arrays;

public class BubblingSort {
    /**
     * 冒泡排序法
     * 使用类似于打擂台的方式来排序
     * **/
    public static void main(String[] args){
        int arr[]={1,5,3,77,44,88,0,99};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int center=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=center;
                }
            }
            System.out.println("第"+i+"次比较的结果为"+ Arrays.toString(arr));
        }
    }


}

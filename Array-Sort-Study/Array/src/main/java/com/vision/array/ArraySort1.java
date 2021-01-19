package com.vision.array;

import java.util.Arrays;

public class ArraySort1 {
    public static void main(String[] args) {
        int arr[] = {23, 45, 2, 66, 0,87,44,1,12,25};
        System.out.println(getIndex(arr,0));
        for (int j =0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length - 1-j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
            System.out.println("第"+(j+1)+"轮比较：" + Arrays.toString(arr));
        }

    }
    private static int getIndex(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if(ele==arr[i]){
                return i; //如果找到 返回下标
            }
        }
        return -1;//如果没找到 返回-1；
    }
}

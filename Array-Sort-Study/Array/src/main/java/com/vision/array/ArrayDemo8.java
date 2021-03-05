package com.vision.array;

import java.util.Scanner;

public class ArrayDemo8 {
    public static void main(String[] args) {
        int arr[]={1,3,6,2,6,7,87};


        int ele=3;
        int index= getIndex(arr,ele);
        System.out.println(ele+"第一次出现的下标为"+index);
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

package com.vision.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int []array={5,3,9,1,6,7,2,4,0,8,342,-2,-54,234,76,-1};
        System.out.println("未排序前："+Arrays.toString(array));
        doQuickSort(0,array.length-1,array);
        System.out.println("快排后："+Arrays.toString(array));
    }
    public static void doQuickSort(int start,int end,int []array){
        if(start<end){
            int index=getIndex(start,end,array);
            doQuickSort(start,index-1,array);
            doQuickSort(index+1,end,array);
        }
    }



    public static int getIndex(int start,int end,int []array){
        int center=array[start];
        while(start<end){
            while(start<end&&center<array[end]){
                end--;
            }
            if(start<end){
                array[start]=array[end];
                start++;
            }
            while(start<end&&center>array[start]){
                start++;
            }
            if(start<end){
                array[end]=array[start];
                end--;
            }
            array[start] =center;
        }
        return start;
    }
}

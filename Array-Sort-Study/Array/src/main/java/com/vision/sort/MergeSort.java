package com.vision.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int []array={4,5,7,8,1,2,3,6,-1,23,45,-33,3,534,23,-4,5};
        System.out.println("未排序前 "+Arrays.toString(array));
        //doMerge(0,(0+array.length-1)/2,array.length-1,array);
        doSplit(array,0,array.length-1);
        System.out.println("两两合并后 "+Arrays.toString(array));
    }

    private static void doSplit(int []arr,int startIndex,int endIndex){
        int centerIndex=(startIndex+endIndex)/2;
        if (startIndex<endIndex){
            doSplit(arr,startIndex,centerIndex);//拆左边序列
            doSplit(arr,centerIndex+1,endIndex);//拆右边序列
            doMerge(startIndex,centerIndex,endIndex,arr);//两两拆分后做两两合并
       }
        //System.out.println("ele "+arr[startIndex]);
    }

    private static void doMerge(int startIndex,int centerIndex,int endIndex,int [] array){
        //System.out.println("startIndex "+startIndex+" centerIndex  "+centerIndex+" endIndex "+endIndex );
        int tempArray[]=new int[endIndex-startIndex+1];//定义临时数组长度
        int leftStartIndex=startIndex;//定义左边数组起始下标
        int rightStartIndex=centerIndex+1;//定义右边数组起始下标
        int tempStartIndex=0;
        while(leftStartIndex<=centerIndex&&rightStartIndex<=endIndex){
            if(array[leftStartIndex]>array[rightStartIndex]){
                tempArray[tempStartIndex]=array[rightStartIndex];
                rightStartIndex++;
            }else {
                tempArray[tempStartIndex]=array[leftStartIndex];
                leftStartIndex++;
            }
            tempStartIndex++;
        }
        while(leftStartIndex<=centerIndex){
            tempArray[tempStartIndex]=array[leftStartIndex];
            leftStartIndex++;
            tempStartIndex++;
        }
        while(rightStartIndex<=endIndex){
            tempArray[tempStartIndex]=array[rightStartIndex];
            rightStartIndex++;
            tempStartIndex++;
        }
        //System.out.println(startIndex);
        for (int i = 0; i < tempArray.length; i++) {
            array[i+startIndex]=tempArray[i];
        }
       // System.out.println(Arrays.toString(array));
      //  System.out.println("tempArray  "+ Arrays.toString(tempArray));
    }
}

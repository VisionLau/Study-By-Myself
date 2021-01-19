package com.vision.array;

public class ArrayDemo9 {
    public static void main(String[] args) {
        int arr[]={1,3,7,8,12,56,77};
        int ele=3;
        int index= getIndex(arr,ele);
        System.out.println(ele+"通过二分查找 第一次出现的下标为"+index);
    }

    private static int getIndex(int[] arr, int ele) {
        int minIndex=0;
        int maxIndex=arr.length-1;
        int centerIndex=(maxIndex-minIndex)/2;
        while (minIndex<=maxIndex){
            if(ele==arr[centerIndex]){
                return centerIndex;
            }else if(ele<arr[centerIndex]){
                maxIndex=centerIndex-1;
            }else if(ele>arr[centerIndex]){
                minIndex=centerIndex+1;
            }
            centerIndex=(maxIndex-minIndex)/2;
        }
        return -1;
    }
}

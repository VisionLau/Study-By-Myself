package com.vision.array;

public class ArrayDemo3 {
    public static void main(String[] args){
        int array[]={10,50,40,60,80};
        int min=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]<min){
                min=array[i];
            }
        }
        System.out.println(min);
    }
}
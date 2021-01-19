package com.vision.sort;

import java.util.Arrays;

public class ChooseSort {
    public static void main(String[] args){ 
        int []num={2,4,1,23,65,0,-34,-2,34,2,0,23,55};
        //int index=0;
        for (int index = 0; index < num.length; index++) {
            for (int i = 1+index; i < num.length; i++) {
                if(num[index]>num[i]){
                   int center=num[i];
                   num[i]=num[index];
                   num[index]=center;
                }
            }
        }
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}

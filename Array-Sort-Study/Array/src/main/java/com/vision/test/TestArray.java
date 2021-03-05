package com.vision.test;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args){
        //System.out.println(Arrays.toString(getOneCount()));
        getOneCount();
    }
    public static void getOneCount(){
        //自定义一个数组 找到该数组中只出现一次的元素
        int array[]={1,3,5,7,2,3,5,7,2,8};
        //int temp[]=new int [array.length];
        for (int i = 0; i < array.length; i++) {
            int count=0;
            for (int i1 = 0; i1 < array.length; i1++) {
                if(array[i]==array[i1]){
                    count+=1;
                }
            }
            if(count==1){
                System.out.println(array[i]);
              //  temp[i]=array[i];
               // return temp;
            }
            //count=0;
        }
        //return null;
    }

}

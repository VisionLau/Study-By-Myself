package com.vision.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int []array={99,3,6,88,34,77,66,22,-2,0,43,22,32,54,231,3,54,11,-4,-32,-88};
        System.out.println("排序前：" + Arrays.toString(array));
        // int foot=4;
        /*int knuth=0;
        while (knuth<=array.length/3){
            knuth=knuth*3+1;
           // System.out.println(knuth);
        }
        //System.out.println(knuth);

        for (int foot =knuth; foot >0; foot=(foot-1)/3) {//控制步长
            for (int i = foot; i < array.length; i++) {
                for (int j = i; j > foot - 1; j -= foot) {
                    if (array[j - foot] > array[j]) {
                        int center = array[j - foot];
                        array[j - foot] = array[j];
                        array[j] = center;
                    }
                }
            }
            System.out.println("步长增量为" + foot + "希尔排序后的结果" + Arrays.toString(array));
        }*/
        for (int foot = array.length/2; foot > 0; foot /= 2) {//控制步长
            for (int i = foot; i < array.length; i++) {
                for (int j = i; j > foot - 1; j -= foot) {
                    if (array[j - foot] > array[j]) {
                        int center = array[j - foot];
                        array[j - foot] = array[j];
                        array[j] = center;
                    }
                }
            }
            System.out.println("普通序列步长增量为" + foot + "希尔排序后的结果" + Arrays.toString(array));
        }

    }
}

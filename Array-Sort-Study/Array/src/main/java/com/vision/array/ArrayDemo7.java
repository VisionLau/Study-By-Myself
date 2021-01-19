package com.vision.array;

import java.util.Scanner;

public class ArrayDemo7 {
    public static void main(String[] args) {
        System.out.println("请输入你要打印的行数：");
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int array[][]=new int[n][n];

        for (int i = 0; i < array.length; i++) {
            array[i][i]=1;
            array[i][0]=1;
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j < i; j++) {
                array[i][j]=array[i-1][j]+array[i-1][j-1];
            }
        }

        for (int i = 0; i < array.length; i++) {
            //打印时消除默认值0
            for (int j = 0; j <=i; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }

    }
}

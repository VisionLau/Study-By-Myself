package com.vision.sparsearray;

import java.io.*;
import java.util.Arrays;

public class ReSparseArray {
    public static void main(String[] args) throws IOException {
        //初始化棋盘  黑棋为1 白棋为2
        int [][]chessArray=new int[10][10];
        chessArray[1][4]=1;
        chessArray[2][4]=2;
        //打印当前棋盘
        System.out.println("当前棋盘为：");
        for (int[] ints : chessArray) {
            System.out.println(Arrays.toString(ints));
        }
        int chessCount=0;
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                if(anInt!=0){
                    chessCount++;
                }
            }
        }
        System.out.println("当前棋盘棋子个数为："+chessCount);
        int [][]sparseArray=new int[chessCount+1][3];
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=chessCount;
        System.out.println(Arrays.toString(sparseArray[0]));
        int sparseArrayIndex=1; //稀疏数组下标从1开始 因为我们使用了下标为0了
        for (int i = 0; i < chessArray.length; i++) {
            for (int i1 = 0; i1 < chessArray[i].length; i1++) {
                //找到棋子
                if(chessArray[i][i1]!=0){
                    sparseArray[sparseArrayIndex][0]=i;//行坐标
                    sparseArray[sparseArrayIndex][1]=i1;//列坐标
                    sparseArray[sparseArrayIndex][2]=chessArray[i][i1];//坐标棋子
                    sparseArrayIndex++;//下标加1
                }
            }
        }
        System.out.println("稀疏数组如下：");
        for (int[] ints : sparseArray) {
            System.out.println(Arrays.toString(ints));
        }

        //写入文件
        String filePath="d:/sparseArray.txt";
        File file=new File(filePath);
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                bufferedWriter.write(anInt+",");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("文件写入成功！");


        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        //char read=1024;
        String str="";
        int [][]reChessArray=null;
        boolean flag=true;
        while ((str=bufferedReader.readLine())!=null){
            String[] split = str.split(",");
            if(flag){
                reChessArray=new int [Integer.valueOf(split[0])][Integer.valueOf(split[1])];
                flag=false;
                continue;
            }
            reChessArray[Integer.valueOf(split[0])][Integer.valueOf(split[1])]=Integer.valueOf(split[2]);
        }
        for (int[] ints : reChessArray) {
            System.out.println(Arrays.toString(ints));
        }
    }

}

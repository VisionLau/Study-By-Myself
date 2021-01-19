package com.vision.sparsearray;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        String filePath="C:/Users/76197/Desktop/sparseArray.txt";
        /*//创建棋盘的二维数组，默认为11*11的大小  黑棋表示1  蓝棋表示2
        int originChessArray[][]=new int [11][11];
        originChessArray[0][3]=1;  //表示再第1行的第3列有一颗黑棋
        originChessArray[1][2]=2;
        System.out.println("原始棋盘如下：");
        int chessCount=0;
        for (int []row:originChessArray){ //遍历行
            for(int ele:row){
                if(ele!=0){
                    chessCount++;
                }
                System.out.print("\t"+ele);
            }
            System.out.println();
        }

        System.out.println("棋盘中共有"+chessCount+"颗棋子");
        int [][]sparseArray=new int[chessCount+1][3];
        sparseArray[0][0]=originChessArray.length;
        sparseArray[0][1]=originChessArray[0].length;
        sparseArray[0][2]=chessCount;
        int sparseArrayIndex=1;
        for (int row = 0; row < originChessArray.length; row++) {
            for (int col = 0; col < originChessArray.length; col++) {
                if(originChessArray[row][col]!=0){
                    sparseArray[sparseArrayIndex][0]=row;
                    sparseArray[sparseArrayIndex][1]=col;
                    sparseArray[sparseArrayIndex][2]=originChessArray[row][col];
                    sparseArrayIndex++;
                }
            }
        }
        System.out.println("稀疏数组的形式如下：");
        for (int []row:sparseArray){ //遍历行
            for(int ele:row){
                System.out.print("\t"+ele);
            }
            System.out.println();
        }

         writeFile(sparseArray,filePath);
        System.out.println("存档成功！");
        */

        //int[][] reSparseArray = readFile(filePath);
        //模拟读档业务
        int [][]reChessArray=readFile(filePath);
        /*for (int reChessRow = 1; reChessRow < reSparseArray.length; reChessRow++) {
            reChessArray[reSparseArray[reChessRow][0]][reSparseArray[reChessRow][1]]=reSparseArray[reChessRow][2];
        }*/
        if(reChessArray!=null){
            System.out.println("读档后的数组如下：");
            for(int []reChess:reChessArray){
                for(int reEle:reChess){
                    System.out.print("\t"+reEle);
                }
                System.out.println();
            }
        }else{
            System.out.println("存档中没有数据！");
        }
        //ConcurrentHashMap
    }

    /**
     *
     * @param sparseArray  稀疏数组
     * @param filePath      写文件路径
     * @throws IOException 异常
     */
    public static void writeFile(int [][]sparseArray,String filePath) throws IOException {
        File file=new File(filePath);
        Writer writer=new FileWriter(file);
        BufferedWriter bufferedWriter=new BufferedWriter(writer);
        String str="";
        try {
            for (int i = 0; i < sparseArray.length; i++) {
                str+=sparseArray[i][0]+","+sparseArray[i][1]+","+sparseArray[i][2]+"\n";
            }
            bufferedWriter.write(str);
        }finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public static int[][] readFile(String filePath) throws IOException {
        int [][]reChessArray=null;
        File file=new File(filePath);
        Reader reader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String str="";
        boolean flag=true;
        while((str=bufferedReader.readLine())!=null){
            String[] split = str.split(",");
            if(flag){
                reChessArray=new int[Integer.valueOf(split[0])][Integer.valueOf(split[1])];
                flag=false;
                continue;
            }
            reChessArray[Integer.valueOf(split[0])][Integer.valueOf(split[1])]=Integer.valueOf(split[2]);
        }
        return reChessArray;
    }
}

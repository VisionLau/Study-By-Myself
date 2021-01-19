package com.vision.sort;

import java.util.Arrays;

public class ReviewSort {
    public static void main(String[] args){
        int []array={1,34,56,67,43,6,9,13,0,-1};
        int startIndex=0;
        int endIndex=array.length-1;
        int centerIndex=(startIndex+endIndex)/2;
        System.out.println("原始数组为  "+ Arrays.toString(array));

        /*bubblingSort3(array);
        System.out.println("经过冒泡排序法后 "+ Arrays.toString(array));*/

       /* chooseSort3(array);
        System.out.println("经过选择排序法后 "+ Arrays.toString(array));*/

       /* directlyInsertedSort2(array);
        System.out.println("经过直接插入排序法后 "+ Arrays.toString(array));*/

        /*hillSort2(array);
        System.out.println("经过希尔排序法后 "+ Arrays.toString(array));*/

        quickSort(array,startIndex,endIndex);
        System.out.println("经过快速排序法后 "+ Arrays.toString(array));
    }


    private static void bubblingSort(int array[]){
        //1,34,56,67,43,6,9,13,0,-1
        //冒泡排序只需要两个元素比较就可以了，前者大于后者，两者互换位置，否则保持不变
        for (int j = 0; j < array.length-1; j++) {
            for (int i = 0; i < array.length-1-j; i++) {
                if(array[i]>array[i+1]){
                    int center=array[i];
                    array[i]=array[i+1];
                    array[i+1]=center;
                }
            }
        }

    }

    private static void chooseSort(int array[]){
        for (int j = 0; j < array.length; j++) {
            for (int i = 1+j; i < array.length; i++) {
                if(array[j]>array[i]){
                    int center=array[j];
                    array[j]=array[i];
                    array[i]=center;
                }
            }
        }

    }

    private static void bubblingSort2(int array[]){
        for (int j = 0; j < array.length-1; j++) {
            for (int i = 0; i < array.length-1; i++) {
                if(array[i]>array[i+1]){
                    int center=array[i];
                    array[i]=array[i+1];
                    array[i+1]=center;
                }
            }
        }
    }

    private static void chooseSort2(int array[]){
        //int index=1;
        for (int index = 0; index < array.length; index++) {
            for (int i = 1+index; i < array.length; i++) {
                if(array[index]>array[i]){
                    int center=array[index];
                    array[index]=array[i];
                    array[i]=center;
                }
            }
        }


    }
    
    private static void  directlyInsertedSort(int array[]){
        //从索引为一开始往前比较  比前面元素小就互换位置
        //第一次循环就可以保证最大的元素在最后面
        for (int i = 1; i < array.length; i++) {
            while(i>0&&array[i]<array[i-1]){
                int center=array[i-1];
                array[i-1]=array[i];
                array[i]=center;
                i--;
            }
        }
    }

    private static void hillSort(int array[]) {
       /*for (int foot=array.length/2;foot>0;foot/=2){
           for (int i = foot; i < array.length; i++) {
               if(array[i]<array[i-foot]){
                   int center=array[i-foot];
                   array[i-foot]=array[i];
                   array[i]=center;
               }
           }
       }*/
        int maxFoot = 1;
        while (maxFoot <= array.length / 3) {
            maxFoot = maxFoot * 3 + 1;
        }
        for (int foot = maxFoot; foot > 0; foot = (foot - 1) / 3) {
            // System.out.println(foot);
            for (int i = foot; i < array.length; i++) {
                for (int j = i; j > foot - 1; j -= foot) {
                    if (array[j - foot] > array[j]) {
                        int center = array[j - foot];
                        array[j - foot] = array[j];
                        array[j] = center;
                    }
                }
            }
        }

    }

    private static void bubblingSort3(int []array){
        //冒泡排序，默认下标为0 的是擂主，与后面的元素逐个比较，大于则交换位置
        //第一轮比较我们就可以将最小的元素放在第一位
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i]>array[i+1]){
                    int center=array[i];
                    array[i]=array[i+1];
                    array[i+1]=center;
                }
            }
        }

    }

   private static void  chooseSort3(int array[]){
        //int index=0;
       for (int index = 0; index < array.length; index++) {
           for (int i = 1+index; i < array.length; i++) {
               if(array[i]<array[index]){
                   int center=array[i];
                   array[i]=array[index];
                   array[index]=center;
               }
           }
       }
   }

   private static void directlyInsertedSort2(int array[]){
        //直接插入排序  我们从下标为1 的元素开始 和前面的元素进行比较，比他大 就互换位置

       for (int i = 1; i < array.length; i++) {
           if(i>0&&array[i]<array[i-1]){
               int center=array[i-1];
               array[i-1]=array[i];
               array[i]=center;
              // i--;
           }
       }
   }

   private static void hillSort2(int array[]){
       //int foot=5;
       //我们通过定义步长增量foot，让当前元素和foot+i的元素进行比较，比他大则互换位置
       //Arrays.sort();
       for (int foot =1; foot <= array.length/3; foot=foot*3+1) {//控制步长
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
       }


   }

   private static void quickSort(int array[],int startIndex,int endIndex){
        if(startIndex<endIndex){
            int index = getIndex(array, startIndex, endIndex);
            //int index = getIndex(startIndex, endIndex, array);
            quickSort(array,0,index-1);
            quickSort(array,index+1,endIndex);
        }
      // System.out.println(index);
   }

   private static int getIndex(int array[],int startIndex,int endIndex){
        int startEle=array[startIndex];
        while (startIndex<endIndex) {
            //找小的
            while(startIndex<endIndex&&startEle<array[endIndex]){
                endIndex--;
            }
            if(startIndex<endIndex){
                array[startIndex]=array[endIndex];
                startIndex++;
            }
            //找大的
            while(startIndex<endIndex&&startEle>array[endIndex]){
                startIndex++;
            }
            if(startIndex<endIndex){
                array[endIndex]=array[startIndex];
                endIndex--;
            }
            array[startIndex]=startEle;
        }
        return startIndex;
   }
}

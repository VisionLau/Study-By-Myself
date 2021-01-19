package com.vision.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args){
        int []array={23,56,3,1,7,443,87,23,12,775,34,2343,133,5,32,568,553};
        //int []array={10,5,156,7,95,32,51};
        System.out.println("未排序前："+ Arrays.toString(array));
        doRadixSort(array);
        System.out.println("基数排序后："+Arrays.toString(array));
    }

    private static void doRadixSort(int[] array){
        //获取数组中最大的元素，获取其最高位 作为最外层循环
        int maxLength=String.valueOf(getMaxEle(array)).length();
        //创建二维数组 每个二维数组代表一个桶  0~9
        int [][]bucket=new int[10][array.length];
        //创建一维数组给二维数组计数  统计对应的二维数组中有多少元素
        int []bucketEleCount=new int[10];
        //div  我们用来取位
        for (int i = 0,div=1; i < maxLength; i++,div*=10) {
            for (int ele = 0; ele < array.length; ele++) {
                int digit=array[ele]/div%10;
                //更具位来存储到对应的二维数组中
                // 同时为了避免后面元素覆盖前面的元素 我们拿一维数组来指定其存储位置 同时计数
                //注意  一维数组此时所有值都是0
                bucket[digit][bucketEleCount[digit]++]=array[ele];
            }
            //从二维数组取值索引
            int index=0;
            //遍历一维数组
            for (int count = 0; count < bucketEleCount.length; count++) {
                //由于一维数组在前面的循环中已经有值了  我们只需要找元素不为0 的即可
                if(bucketEleCount[count]!=0){
                    //遍历  比如当前一维数组有个元素为1且下标为0  那么它所对应的二维数组中就有一个值
                    for (int countEle = 0; countEle < bucketEleCount[count]; countEle++) {
                        //重新赋值给排序数组  count:那个桶  countEle取那个值
                        array[index++]=bucket[count][countEle];
                    }
                    //我们此时已经取完值了，一维数组将重新计数
                    bucketEleCount[count]=0;
                }
            }
        }
    }
    
    private static int getMaxEle(int []array){
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
}

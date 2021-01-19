package com.vision.array;

public class ReArray {
    //来练习数据的查找
    //普通遍历查找
    public static int simpleSearch(int []nums,int searchNum){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==searchNum){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * @param nums 只能是排列有序的数组
     */

    public static int binarySearch(int []nums,int searchNum){
        int minLength=0;
        int maxLength=nums.length-1;
        int centerLength=(maxLength+minLength)/2;

        while(minLength<=maxLength){
            if(nums[centerLength]==searchNum){
                return centerLength;
            }else if(nums[centerLength]>searchNum){
                maxLength=centerLength-1;
            }else if(nums[centerLength]<searchNum){
                minLength=centerLength+1;
            }
            centerLength=(maxLength+minLength)/2;
        }
        return -1;
    }

    public static void main(String[] args){
        int []nums={8,15,32,42,65,99};
      //  System.out.println(simpleSearch(nums,99));
        System.out.println(binarySearch(nums,99));
    }
}

import java.util.Arrays;
import java.util.HashMap;

public class TheSumOfTwoNumbers {
    /**给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     你可以按任意顺序返回答案。
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/two-sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public static void main(String[] args){
        int []nums={1,2,3,3};
        System.out.println(Arrays.toString(twoSum(nums,6)));

    }
    /**解题思路
     * 1. 首先我们就要根据条件创建一个数组进行存储下标和返回  当然也可以在返回时创建
     * 2. 题目条件要求原数组中的每个元素只能使用一次  所以我们创建一个hashNums来存储对应值
     * 3. 遍历原数组是比不可少的
     *    我们着重来来分析一下这个if判断
     *    我们可以先看不满足时，hashNums做了些什么
     *    我们将target直接减去当前遍历得到的元素，再将其下标存起来
     *    比如 原数组为{1,2,3,3}; target为6
     *    那么前两轮进去遍历两元素之和不会为6
     *    接着 遍历到下标为2时 hashNums将6-3作为键存入  下标2为值
     *    下轮遍历开始时  下标为3的元素 进入判断  结果为hashNums存在键 返回true
     * */
    public static int[] twoSum(int[] nums, int target) {
       // int []targetArray=new int[2];
        HashMap<Integer,Integer>hashNums=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashNums.containsKey(nums[i])){
               // targetArray[0]=i;
                //targetArray[1]=hashNums.get(nums[i]);
               // return targetArray;
                return new int[]{i,hashNums.get(nums[i])};
            }
            hashNums.put(target-nums[i],i);
        }
        return null;
    }
}

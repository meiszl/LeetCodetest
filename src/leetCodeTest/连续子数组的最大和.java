package leetCodeTest;

import java.util.Arrays;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println("i = " + i);
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int i,temp = nums[0],count = nums[0];
        for (i=1;i<nums.length;i++){
            count = Math.max(count + nums[i],nums[i]);
            temp = Math.max(temp,count);
        }
        return temp;
    }
}

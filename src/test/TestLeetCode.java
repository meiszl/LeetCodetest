package test;

import java.util.Arrays;

public class TestLeetCode {
    public static void main(String[] args) {
        //最长上升子序列
        int nums[] = {1,3,6,7,9,4,10,5,6};//[1,3,6,7,9,4,10,5,6]
        final int i = lengthOfLIS(nums);
        System.out.println("i = " + i);
    }
    public static int lengthOfLIS(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length];
        Arrays.fill(sum,1);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    sum[i] = Math.max(sum[i],sum[j] + 1);
                    count = Math.max(count,sum[i]);
                }
            }
        }
        return count;
    }
}

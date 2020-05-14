package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 2;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 暴力算法
     *
     * @param nums
     * @param k
     * @return
     */
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null|| nums.length < k) return null;
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i + k<= nums.length; i++) {
//            int temp = Integer.MIN_VALUE;
//            for (int j = i; j < i+k; j++) {
//                temp = Math.max(temp,nums[j]);
//            }
//            res[i] = temp;
//        }
//        return res;
//    }

    /**
     * 动态规划，双数组规划，左数组与右数组。
     * 详解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }
}

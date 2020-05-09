package leetCodeTest;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

public class 乘积最大连续子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,-1,4};
        int i = maxProduct(nums);
        System.out.println("i = " + i);
    }

    /**
     * 动态规划单数组
     * @param nums
     * @return
     */
//    public static int maxProduct(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        sum[1] = Math.max(nums[0] * nums[1],nums[1]);
//        int max = Math.max(sum[0],sum[1]);
//        int tem;
//        for (int i = 2; i < nums.length; i++) {
//            tem = nums[i];
//            int temp = nums[i];
//            for (int j = i - 1; j >= 0; j--) {
//                temp *= nums[j];
//                tem = Math.max(temp,tem);
//            }
//            sum[i] = tem;
//            max = Math.max(sum[i],max);
//        }
//        return max;
//    }

    /**
     * 动态规划双数组法
     * @param nums
     * @return
     */
//    public static int maxProduct(int[] nums) {
//        int n = nums.length;
//        if (n==0){
//            return 0;
//        }
//        int[] dpMax = new int[n];
//        dpMax[0] = nums[0];
//        int[] dpMin = new int[n];
//        dpMin[0] = nums[0];
//        int max = nums[0];
//        for (int i = 1; i < n; i++) {
//            dpMax[i] = Math.max(dpMin[i-1]*nums[i],Math.max(dpMax[i-1]*nums[i],nums[i]));
//            dpMin[i] = Math.min(dpMin[i-1]*nums[i],Math.min(dpMax[i-1]*nums[i],nums[i]));
//            max = Math.max(max,dpMax[i]);
//        }
//        return max;
//    }

    /**
     * 动态规划，双变量法
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if (n==0){
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int preMax = dpMax;
            dpMax = Math.max(dpMin*nums[i],Math.max(dpMax*nums[i],nums[i]));
            dpMin = Math.min(dpMin*nums[i],Math.min(preMax*nums[i],nums[i]));
            max = Math.max(max,dpMax);
        }
        return max;
    }
}

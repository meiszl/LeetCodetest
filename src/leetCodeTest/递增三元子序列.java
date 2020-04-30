package leetCodeTest;

import java.util.Arrays;

public class 递增三元子序列 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,0,3};
        boolean b = increasingTriplet(nums);
        System.out.println("b = " + b);
    }

    /**
     * 动态规划法。速度最慢
     * @param nums
     * @return
     */
//    public static boolean increasingTriplet(int[] nums) {
//        if (nums == null || nums.length <= 2)return false;
//        int[] sum = new int[nums.length];
//        sum[0] = 0;
//        int i,j;
//        for (i = 0; i < nums.length; i++) {
//            for (j=0;j <i;j++){
//                if (nums[i] > nums[j]){
//                    sum[i] = Math.max(sum[i],sum[j] + 1);
//                }
//                if (sum[i] >=2)
//                    return true;
//            }
//        }
//        return false;
//    }

    /**
     * 双指针法。
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2)return false;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= left){
                left = num;
            }else if (num <= right){
                right = num;
            }else {
                return true;
            }
        }
        return false;
    }
}

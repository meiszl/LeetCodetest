package leetCodeTest;

import java.util.Arrays;

public class 分割等和字符串 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println("b = " + b);
    }
    /**
     * 动态规划算法。
     */
//    public static boolean canPartition(int[] nums) {
//        int len = nums.length;
//        if (len == 0)return false;
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if ((sum&1) == 1) return false;
//        int target = sum/2;
//        boolean[][] dp = new boolean[nums.length][target+1];
//        if (nums[0] <= target)
//            dp[0][nums[0]] = true;
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j <= target; j++) {
//                dp[i][j] = dp[i-1][j];
//                if (nums[i] == j){
//                    dp[i][j] = true;
//                    continue;
//                }
//                if (nums[i]<j){
//                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
//                }
//            }
//        }
//        return dp[len-1][target];
//    }

    /**
     * dfs+剪枝算法。
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (nums.length == 0)return false;
        if ((sum&1) == 1) return false;
        sum >>= 1;
        return Partition(nums,nums.length - 1,sum,sum);
    }
    public static boolean Partition(int[] nums,int idx,int head,int pass){
        if (pass == 0||head == 0){
            return true;
        }else if (pass < 0||head < 0){
            return false;
        }else {
            return Partition(nums,idx-1,head,pass - nums[idx])||Partition(nums,idx-1,head-nums[idx],pass);
        }
    }
}

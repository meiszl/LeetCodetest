package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 戳气球 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        int i = maxCoins(nums);
        System.out.println("i = " + i);
    }
    public static int maxCoins(int[] nums) {
        int[] sum = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = nums[i];
        }
        sum[0] = sum[sum.length-1] = 1;
        int[][] memo = new int[sum.length][sum.length];
        return dp(memo,sum,0,sum.length-1);
    }
    public static int dp(int[][] memo,int[] sum,int left,int right){
        if (left +1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left+1; i < right; i++) {
            ans = Math.max(ans,sum[left]*sum[i] * sum[right] +
                    dp(memo, sum, left, i) + dp(memo, sum, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}

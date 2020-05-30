package leetCodeTest;

import java.util.Arrays;

public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        int n = 3;
        int i = numTrees(n);
        System.out.println("i = " + i);
    }
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //选择为根的点
        for (int i = 2; i <= n; i++) {
            //计算乘积和
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[dp.length-1];
    }
}

package leetCodeTest;

import java.util.Arrays;

public class n个骰子的点数 {
    public static void main(String[] args) {
        int n = 2;
        double[] doubles = twoSum(n);
        System.out.println("doubles = " + Arrays.toString(doubles));
    }

    /**
     * 动态规划
     * 详解：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/dong-tai-gui-hua-by-shy-14/
     * @param n
     * @return
     */
    public static double[] twoSum(int n) {
        //dp[n][s]存储的是n个骰子的情况下和为s的情况数量。
        int[][] dp = new int[n+1][6*n+1];
        double all = Math.pow(6,n);
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i*6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j-k<i-1) break;
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double[] res = new double[5*n+1];
        for (int i = n; i <= 6*n; i++) {
            res[i-n] =((double) dp[n][i]) / all;
        }
        return res;
    }
}


package leetCodeTest;

import java.util.Arrays;

public class 合并金币 {
    public static void main(String[] args) {
        int n = 5,i;
        int[] c = new int[n];
        int[] sum = new int[n];
        int[][] dp = new int[n][n];
        for (i=1;i<n;i++){
            c[i] = i;
            sum[i] = sum[i-1] + c[i];
            dp[i][i] = 0;
        }
        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
        System.out.println("Arrays.toString(sum) = " + Arrays.toString(sum));
        int len;
        for (len = 1;len < n;len++){
            for (i=1;i+len<n;i++){
                int wei = i+len;
                for (int k=i;k<wei;k++){
                    System.out.print("i=" + i + " wei=" + wei + " k=" + k + " k+1=" + (k+1) + " i-1=" + (i-1));
                    System.out.println();
                    dp[i][wei] = Math.max(dp[i][wei],dp[i][k]+dp[k+1][wei]+sum[wei]-sum[i-1]);
                }
            }
        }
        for (i=0;i<dp.length;i++){
            System.out.println("Arrays.toString(dp[i]) = " + Arrays.toString(dp[i]));
        }
    }
}

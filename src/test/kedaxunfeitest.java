package test;

import java.util.Scanner;

public class kedaxunfeitest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int m = Integer.valueOf(split[0]);
        int n = Integer.valueOf(split[1]);
        int[][] value = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0&& j == 0){
                    dp[i][j] = value[i][j];
                }else if (i == 0)
                    dp[i][j] = dp[i][j-1] + value[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i-1][j] + value[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j] + value[i][j],dp[i][j-1] + value[i][j]);
                max = Math.max(dp[i][j],max);
            }
        }
        System.out.println(dp[m-1][n-1]);
    }
}

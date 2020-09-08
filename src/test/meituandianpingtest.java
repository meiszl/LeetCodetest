package test;

import java.util.Arrays;
import java.util.Scanner;

public class meituandianpingtest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[2*n-1][2*n-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*(i+1)-1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        int[][] dp = new int[2*n][2*n];
        dp[0][0] = 0;
        //三个状态标识左下中间右下
        dp[0][0] = matrix[0][0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2*(i+1)-1; j++) {
                if (j > 0)
                    dp[i][j] = Math.max(dp[i-1][j] + matrix[i][j],Math.max(dp[i-1][j-1] + matrix[i][j],
                            dp[i-1][j+1] + matrix[i][j]));
                else
                    dp[i][j] = Math.max(dp[i-1][j] + matrix[i][j],dp[i-1][j+1] + matrix[i][j]);
                max = Math.max(dp[i][j],max);
            }
        }
        System.out.println(max);
    }
}

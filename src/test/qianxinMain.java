package test;

import java.util.Scanner;

public class qianxinMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] values = {2,2,3,1,5,2};
        int[] weights = {2,3,1,5,4,3};
        int[] dp = new int[15];
        for (int i = 0; i < 6; i++) {
            for (int j = N;j >= values[i];j--){
                dp[j] = Math.max(dp[j],dp[j-values[i]] + weights[i]);
            }
        }
        System.out.println(dp[N-1]);
    }
}

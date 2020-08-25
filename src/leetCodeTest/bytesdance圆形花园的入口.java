package leetCodeTest;

import java.util.Scanner;

public class bytesdance圆形花园的入口 {
    /**
     * 小区花园里有n个入口，现在要修一些路，
     * 要求每个入口只能有一条路，且每条路之间互不相交，
     * 求输入为n的时候有几中修路的方式。
     * n是一个输入为2-1000的偶数。
     *
     * 也就是偶数个圆上的点画不相交的直线有多少种画法。
     *
     * 动态规划
     *
     * 解法：https://blog.csdn.net/qq_23262411/article/details/100080855
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[2] = 1;
        // 每次跳两个点，题目要求是偶数
        for (int i = 4; i < n + 1; i += 2) {
            // 拿出作为起点终点的两个点，之后剩下i-2个点
            // 每次跳两个点是为保证两部分内部直线不相交
            for (int j = 0; j < i-2+1; j += 2) {
                dp[i] += dp[i-2-j]*dp[j];
            }
        }
        System.out.println(dp[n]);
    }
}

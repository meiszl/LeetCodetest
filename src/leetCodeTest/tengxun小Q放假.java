package leetCodeTest;

import java.util.Scanner;

public class tengxun小Q放假 {
    /**
     * 公司给小Q放了n天的假,他有个奇怪的习惯:不会连续两天工作或段炼
     * 只有当公司开业,小Q才能去工作,
     * 只有当健身房营业时,小O才能去健身,
     * 小Q一天只能干一件事.给出假期中公司,健身房的营业情兄,求小Q最少需要体息几天
     * 输入描述第ー行一个数表示放假天数n
     * 第二行n个数字，数字为0或者1,第i个数表示公司在第1天是否营业
     * 第三行n个数字，数字为0或者1,第i个数表示健身房在第i天是否营业
     * （1为营业0为不营业)
     *
     * example
     * 输入
     * 4
     * 1 1 0 0
     * 0 1 1 0
     *
     * 思路：https://blog.csdn.net/zycxnanwang/article/details/101878823
     *
     * 输出
     * 小Q可以在第一天工作，第二或者第三健身，最少休息两天
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[3][100000];
        int[] work = new int[100000];
        int[] keep = new int[100000];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            work[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            keep[i] = sc.nextInt();
        }
        //如果第一天休息，休息天数为1
        dp[0][0] = 1;
        //如果可以工作，休息天数为0
        if (work[0] == 1)
            dp[1][0] = 0;
        else
            dp[1][0] = n;
        //如果可以健身，休息天数为0
        if (keep[0] == 1)
            dp[2][0] = 0;
        else
            dp[2][0] = n;
        int coun = 0;
        for (int i = 1; i < n; i++) {
            int min_num = dp[0][i-1];
            if (work[i-1] == 1)
                min_num = Math.min(dp[1][i-1],min_num);
            if (keep[i-1] == 1)
                min_num = Math.min(dp[2][i-1],min_num);
            dp[0][i] = min_num + 1;
            if (work[i] == 1){
                if (keep[i-1] == 1)
                    dp[1][i] = Math.min(dp[0][i-1],dp[2][i-1]);
                else
                    dp[1][i] = dp[0][i-1];
            }
            else
                dp[1][i] = n;
            if (keep[i] == 1) {
                if (work[i-1] == 1)
                    dp[2][i] = Math.min(dp[0][i-1],dp[1][i-1]);
                else
                    dp[2][i] = dp[0][i-1];
            }
            else
                dp[2][i] = n;
        }
        coun = Math.min(dp[0][n-1],Math.min(dp[1][n-1],dp[2][n-1]));
        System.out.println(coun);
    }
}

package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 完全平方数 {
    public static void main(String[] args) {
        int n = 388;
        int i = numSquares(n);
        System.out.println("i = " + i);
    }

    /**
     * 递归优化法
     */
//    private static int resmin;
//    public static int numSquares(int n) {
//        resmin = Integer.MAX_VALUE;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (i*i <= n)
//                list.add(i*i);
//            else
//                break;
//        }
//        Collections.reverse(list);
//        System.out.println("list = " + list);
//        findMin(list,n,0,0);
//        return resmin;
//    }
//    public static void findMin(List<Integer> list,int res,int count,int fla){
//        if (res == 0){
//            resmin = Math.min(resmin,count);
//        }
//        if (count >= resmin){
//            return;
//        }
//        for (int i = fla; i < list.size(); i++) {
//            if (res - list.get(i) >= 0)
//                findMin(list, res - list.get(i), count + 1,i);
//        }
//    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int sqlen = (int)Math.sqrt(n) + 1;
        int[] sq = new int[sqlen];
        int i;
        for (i=1;i<sqlen;i++){
            sq[i] = i*i;
        }
        for (i=1;i<=n;i++){
            for (int j = 1; j < sqlen; j++) {
                if (i<sq[j])
                    break;
                dp[i] = Math.min(dp[i],dp[i-sq[j]] + 1);
            }
        }
        return dp[n];
    }
}

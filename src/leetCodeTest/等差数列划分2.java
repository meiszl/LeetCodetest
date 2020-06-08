package leetCodeTest;

import java.util.HashMap;
import java.util.Map;

public class 等差数列划分2 {
    public static void main(String[] args) {
        int[] A = new int[]{2, 4, 6, 8, 10};
        int i = numberOfArithmeticSlices(A);
        System.out.println("i = " + i);
    }

    /**
     * 动态规划。
     * 详解：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/solution/deng-chai-shu-lie-hua-fen-ii-zi-xu-lie-by-leetcode/
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null||A.length == 0) return 0;
        int n = A.length,res = 0;
        Map<Integer,Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = ((long) A[i]) - ((long) A[j]);
                if (d<Integer.MIN_VALUE || d>Integer.MAX_VALUE)
                    continue;
                int d1 = (int) d;
                Integer sum = dp[j].getOrDefault(d1, 0);
                Integer origin = dp[i].getOrDefault(d1, 0);
                dp[i].put(d1,sum+origin+1);
                res += sum;
            }
        }
        return res;
    }
}

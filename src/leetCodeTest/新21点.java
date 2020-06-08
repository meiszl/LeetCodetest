package leetCodeTest;

public class 新21点 {
    public static void main(String[] args) {
        int N = 21;
        int K = 17;
        int W = 10;
        double v = new21Game(N, K, W);
        System.out.println("v = " + v);
    }
    /**
     * 暴力解法，超时。
     */
//    private static double res = 0;
//    public static double new21Game(int N, int K, int W) {
//        find(N,K,W,0,0);
//        return res;
//    }
//    public static void find(int N,int K,int W,int count,int docoun){
//        if (count >= K){
//            System.out.println("count = " + count);
//            System.out.println("docoun = " + docoun);
//            if (count <= N) {
//                res += Math.pow(1/(double)W,docoun);
//            }
//            return;
//        }
//        for (int i = 1; i <= W; i++) {
//            docoun++;
//            count += i;
//            find(N, K, W, count, docoun);
//            docoun--;
//            count -= i;
//        }
//    }

    /**
     * 动态规划
     * 详解：https://leetcode-cn.com/problems/new-21-game/solution/xin-21dian-by-leetcode-solution/
     * @param N
     * @param K
     * @param W
     * @return
     */
    public static double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}

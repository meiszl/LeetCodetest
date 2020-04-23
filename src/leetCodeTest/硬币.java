package leetCodeTest;

public class 硬币 {
    public static void main(String[] args) {
        int n = 5;
        int i = waysToChange(5);
        System.out.println("i = " + i);
    }
    private static int mod = 1000000007;
    private static int[] coins = {25, 10, 5, 1};
    public static int waysToChange(int n) {
        int i,j;
        int[] sum = new int[n+1];
        sum[0] = 1;
        for (i=0;i<4;i++){
            int coin = coins[i];
            //统计方案时，总价值最少要达到coin的值
            for (j=coin;j<=n;j++){
                //状态转移方程：当前的方案数量等于总硬币价值达到i-coin的方案数量+当前已经记录的方案数量
                sum[j] = (sum[j] + sum[j - coin]) % mod;
            }
        }
        return sum[n];
    }
}

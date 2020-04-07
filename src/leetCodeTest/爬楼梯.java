package leetCodeTest;

import java.util.Arrays;

public class 爬楼梯 {
    public static void main(String[] args) {
        int n = 3;
        int i = climbStairs(n);
        System.out.println(i);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        int i;
        int[] a = new int[n+1];
        a[0] = 1;
        a[1] = 2;
        for (i=2;i<n+1;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[a.length-2];
    }
    /**
     * 递归算法
     */
//    public int climbStairs(int n) {
//        climb_Stairs(0, n);
//    }
//    public int climb_Stairs(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
//    }
}

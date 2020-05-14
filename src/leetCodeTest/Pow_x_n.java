package leetCodeTest;

public class Pow_x_n {
    public static void main(String[] args) {
        double x = 2;
        int n = 4;
        double v = myPow(x, n);
        System.out.println("v = " + v);
    }

    /**
     * 快速幂解法
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (x==0||(n == 0 && x == 0))return 0;
        long N = n;
        return n>0?quickmul(x,N):1/quickmul(x,-N);
    }
//    public static double quickmul(double x,long N){
//        if (N==0) return 1.0;
//        double y = quickmul(x,N/2);
//        return N%2==0? y*y:y*y*x;
//    }
    /**
     * 快速幂，简化空间复杂度的方法
     */
    public static double quickmul(double x,long N){
        double ans = 1.0;
        double x_con = x;
        while (N > 0){
            if (N%2 == 1){
                ans*=x_con;
            }
            x_con *= x_con;
            N = N >>>1;
        }
        return ans;
    }
}

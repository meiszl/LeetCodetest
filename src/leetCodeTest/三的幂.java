package leetCodeTest;

public class 三的幂 {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        boolean powerOfThree = isPowerOfThree(n);
        System.out.println("powerOfThree = " + powerOfThree);
    }

    /**
     * 快速幂解法
     *
     * @param n
     * @return
     */
//    public static boolean isPowerOfThree(int n) {
//        long temp = 3;
//        if (n == 1||n==3) return true;
//        if (temp > n) return false;
//        while (temp < n){
//            if (temp*temp < n){
//                temp = temp*temp;
//            }else {
//                temp = temp*3;
//            }
//            if (temp == n)
//                return true;
//        }
//        return false;
//    }

    /**
     * 整数限制，由于int型最多存储32位字节所以最大的整数为3^19所以可以得到如下的方案。
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

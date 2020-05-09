package leetCodeTest;

public class x的平方根 {
    public static void main(String[] args) {
        int x =2147395599;
        int i = mySqrt(x);
        System.out.println("i = " + i);
    }

    /**
     * 方法实现较慢
     * @param x
     * @return
     */
//    public static int mySqrt(int x) {
//        if (x == 0|| x == 1) return x;
//        long count = x;
//        while (count*count > x){
//            count = count >>> 1;
//        }
//        while (count*count < x){
//            count++;
//        }
//        return count*count <= x?(int) count:(int) count-1;
//    }

    /**
     * 袖珍计算器法，根据底层计算实现原理将根号化为e的平方形式求解
     * 详解：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     * @param x
     * @return
     */
//    public static int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int ans = (int)Math.exp(0.5 * Math.log(x));
//        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
//    }

    /**
     * 二分查找法,将x看为线段的结尾，使用二分查找找到线段中间的平方数。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int l=0,r=x,ans = -1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if ((long)mid*mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid-1;
            }
        }
        return ans;
    }
}

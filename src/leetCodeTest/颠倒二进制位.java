package leetCodeTest;

public class 颠倒二进制位 {
    public static void main(String[] args) {
        int n = 3;
        int i = reverseBits(n);
        System.out.println("i = " + i);
    }
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 31;n!=0;n = n>>>1,i--) {
            ans += (n&1) << i;
        }
        return ans;
    }
}

package leetCodeTest;

public class 整数1_n中1的出现次数 {
    public static void main(String[] args) {
        int n=13;
        int i = countDigitOne(n);
        System.out.println("i = " + i);
    }

    /**
     * 找出数字之间的规律即可解题，
     * 按位拆分数字为三个部分，高位部分(high)，当前位部分(cur)，低位部分(low)并记录是哪一位位序digits（个位十位百位...），
     * 循环让当前位部分前移直到判断完搜有的位。
     * 当cur为0的时候则该位为1的数字个数为高位乘以位序，即high*digits,
     * 当cur为1的时候该位为1的数字个数为high*digits+low+1,
     * 当cur大于1的时候该位为1的数字个数为(high+1)*digits.
     * 详解：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int res = 0;
        int digfl = 1;
        int high = n/10,low = 0,cur = n%10;
        while (high!=0||cur!=0){
            if (cur == 0) res +=high*digfl;
            else if (cur == 1) res += high*digfl+low+1;
            else if (cur > 1) res += (high+1)*digfl;
            low += cur*digfl;
            cur = high % 10;
            high = high / 10;
            digfl *= 10;
        }
        return res;
    }
}

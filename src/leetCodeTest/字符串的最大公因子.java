package leetCodeTest;

public class 字符串的最大公因子 {

    public static void main(String[] args) {
        String str1 = "ABCABCABC";
        String str2 = "ABCABC";
        final String s = gcdOfStrings(str1, str2);
        System.out.println("s = " + s);
    }

    /**
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/java-hen-jian-ji-yi-yan-jiu-neng-kan-ming-bai-by-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
}

package leetCodeTest;


public class 最长回文串 {
    public static void main(String[] args) {
        String s = new String("abccccdd");
        final int i = longestPalindrome(s);
        System.out.println("i = " + i);
    }

    /**
     * 因为回文串最多拥有一组奇数字符，所以考虑将字符串内的奇数字符全部修改为偶数字符进行构造
     * 遍历字符串得到所有字符的统计数，然后将每个奇数字符减1得到该字符的偶数串，
     * 最后判断多出来多少个1，然后用原字符串长度减去这些1最后再加上最中间的字符即可。
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char c: s.toCharArray()){
            arr[c]++;
        }
        int count = 0;
        for (int i:arr){
            count += (i%2);
        }
        return count == 0? s.length():(s.length() - count + 1);
    }
}

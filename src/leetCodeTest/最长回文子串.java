package leetCodeTest;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println("s1 = " + s1);
    }
    /**
     * 传统的区间规划法，超时
     */
//    public static String longestPalindrome(String s) {
//        if (s.length() == 0 || s.length() == 1)
//            return s;
//        int len,i,j;
//        String res = "";
//        boolean flag = true;
//        for (len=1;len<=s.length();len++){
//            for (i=0;i+len<=s.length();i++){
//                String substring = s.substring(i, i + len);
//                flag = true;
//                for (j=0;j<substring.length()/2;j++){
//                    if (substring.charAt(j) != substring.charAt(substring.length()-1-j))
//                        flag = false;
//                }
//                if (flag && res.length() < substring.length())
//                    res = substring;
//
//            }
//        }
//        return res;
//    }

    /**
     * 中心扩散法+区间规划
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

}

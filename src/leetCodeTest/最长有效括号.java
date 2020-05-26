package leetCodeTest;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class 最长有效括号 {
    public static void main(String[] args) {
        String s = ")()())";
        int i = longestValidParentheses(s);
        System.out.println("i = " + i);
    }
    /**
     * 暴力法，超时。
     */
//    private static char[] chars;
//    public static int longestValidParentheses(String s) {
//        chars = s.toCharArray();
//        int len,j,count = 0;
//        for (len = 2; len <= chars.length; len += 2) {
//            for (j=0;j<=chars.length-len;j++){
//                if (vaild(j,j+len)) {
//                    count = Math.max(count, len);
//                    break;
//                }
//            }
//        }
//        return count;
//    }
//    public static boolean vaild(int i,int j){
//        Deque<Character> deque = new LinkedList<>();
//        for (int k = i; k < j; k++) {
//            if (chars[k] == '(') {
//                deque.addFirst('(');
//            } else if (!deque.isEmpty() && deque.peekFirst() == '(') {
//                deque.pollFirst();
//            } else {
//                return false;
//            }
//        }
//        return deque.isEmpty();
//    }

    /**
     * 动态规划，
     * 详解1：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     * 详解2：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/qiao-miao-de-dong-tai-gui-hua-by-byb_boy/
     * @param s
     * @return
     */
//    public static int longestValidParentheses(String s) {
//        char[] chars = s.toCharArray();
//        int[] dp = new int[s.length()];
//        int count = 0;
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] == ')'){
//                if (chars[i-1] == '('){
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                }else if (i-dp[i-1] > 0&&chars[i-dp[i-1]-1]=='('){
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                }
//                count = Math.max(count,dp[i]);
//            }
//        }
//        return count;
//    }
    /**
     * 双指针计数法,比线性规划要慢。因为循环了2次。
     */
    public static int longestValidParentheses(String s) {
        int left = 0,right = 0,count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                count = Math.max(count,2*right);
            }else if (right >= left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')'){
                right++;
            }else {
                left++;
            }
            if (left == right){
                count = Math.max(left * 2,count);
            }else if (left >= right){
                left = right = 0;
            }
        }
        return count;
    }
}

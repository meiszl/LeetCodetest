package leetCodeTest;

import java.util.*;

public class 单词拆分 {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<String>(){{
            add("aaaa");
            add("aaa");
//            add("sand");
//            add("and");
//            add("cat");
        }};
        boolean b = wordBreak(s, wordDict);
        System.out.println("b = " + b);
    }

    /**
     * 记忆化回溯
     */
//    private static HashSet<String> Dict;
//    private static Boolean[] memo;
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length()==0&&wordDict.size()!=0) return false;
//        Dict = new HashSet<>(wordDict);
//        memo = new Boolean[s.length()];
//        return find(s, 0);
//    }
//    public static boolean find(String s,int i){
//        if (i == s.length())
//            return true;
//        if (memo[i] != null){
//            return memo[i];
//        }
//        for (int j = i+1; j <= s.length(); j++) {
//            if (Dict.contains(s.substring(i,j))&&find(s, j)) {
//                return memo[i] = true;
//            }
//        }
//        return memo[i] = false;
//    }

    /**
     * 宽度树
     * 详解：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/
     * @param s
     * @param wordDict
     * @return
     */
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        HashSet<String> hashSet = new HashSet<>(wordDict);
//        Deque<Integer> deque = new LinkedList<>();
//        deque.addFirst(0);
//        boolean[] memo = new boolean[s.length()];
//        while (!deque.isEmpty()){
//            Integer poll = deque.pollLast();
//            if (!memo[poll]){
//                for (int i = poll+1; i <= s.length(); i++) {
//                    if (hashSet.contains(s.substring(poll,i))){
//                        deque.addFirst(i);
//                        if (i == s.length())
//                            return true;
//                    }
//                }
//            }
//            memo[poll] = true;
//        }
//        return false;
//    }

    /**
     * 线性规划
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&&hashSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}

package leetCodeTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 分割回文字符串 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = partition(s);
        System.out.println("partition = " + partition);
    }

    /**
     * 回溯算法求回文子串
     * 详解：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     */
    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();

        Search(s,0,len,stack,res);
        return res;
    }
    public static void Search(String s,int start,int len,Deque<String> path,List<List<String>> res){
        if (start == len){
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < len; i++) {
            if (!find(s,start,i)){
                continue;
            }
            path.add(s.substring(start,i+1));
            Search(s,i+1,len,path,res);
            path.removeLast();
        }
    }
    public static boolean find(String s,int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

package leetCodeTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaa";
        int i = countSubstrings(s);
        System.out.println("i = " + i);
    }

    /**
     * 传统暴力法。
     */
//    private static char[] tems;
//    private static int res;
//    public static int countSubstrings(String s) {
//        tems = s.toCharArray();
//        res = 0;
//        for (int i = 0; i < tems.length; i++) {
//            find(i,new StringBuilder());
//        }
//        return res;
//    }
//    public static void find(int i, StringBuilder str){
//        if (i >= tems.length)
//            return;
//        for (int j = i; j < tems.length; j++) {
//            str.append(tems[j]);
//            if (vaild(str.toString()))
//                res++;
//        }
//    }
//    public static boolean vaild(String str){
//        for (int k = 0; k < str.length()/2; k++) {
//            if (str.charAt(k) != str.charAt(str.length()-k-1))
//                return false;
//        }
//        return true;
//    }

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length*2; i++) {
            int left = i/2;
            int right = left + i%2;
            while (left >=0&&right < chars.length&&chars[left]==chars[right]){
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}

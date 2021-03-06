package leetCodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s==null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256];
        for (char c: p.toCharArray()) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {

            if (hash[s.charAt(right)] > 0) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }
}

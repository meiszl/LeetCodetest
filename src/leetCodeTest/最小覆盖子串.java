package leetCodeTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "aa";//ADOBECODEBANC
        String t = "aa";//ABC
        String s1 = minWindow(s, t);
        System.out.println("s1 = " + s1);
    }

    /**
     * 滑动窗口。
     * 详解：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-2/
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) return "";
        HashMap<Character,Integer> dictT = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i),dictT.getOrDefault(t.charAt(i),0) + 1);
        }
        int l = 0,r = 0;
        int require = dictT.size();
        int formed = 0;
        int[] ans = {-1,0,0};
        HashMap<Character,Integer> windowCounts = new HashMap<>();
        while (r<s.length()){
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c,0);
            windowCounts.put(c,count + 1);
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()){
                formed++;
            }
            while (l <= r && formed == require){
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c,windowCounts.get(c) - 1);
                if (dictT.containsKey(c)&&windowCounts.get(c).intValue() < dictT.get(c).intValue()){
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1?"":s.substring(ans[1],ans[2] + 1);
    }
}

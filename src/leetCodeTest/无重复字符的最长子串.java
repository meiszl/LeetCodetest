package leetCodeTest;

import java.util.Arrays;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = new String("abcabcbb");
        final int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }
    /**
     * 记录KMP模式匹配算法中的next数组求法。
     * @param s
     * @return
     */
//    public static int lengthOfLongestSubstring(String s) {
//        final int length = s.length();
//        int i = 1,k = 0;
//        int next[] = new int[length];
//        for (i = 1;i<length - 1;i++){
//            while (k > 0 && s.charAt(i) != s.charAt(k)){
//                k = next[k-1];
//            }
//            if (s.charAt(i) == s.charAt(k))
//                k++;
//            next[i] = k;
//        }
//        System.out.println(Arrays.toString(next));
//        int temp = 0;
//        for (int ne: next){
//            if (ne > temp)
//                temp = ne;
//        }
//        if (temp == 0)
//            return 0;
//        else
//            return temp;
//    }
}

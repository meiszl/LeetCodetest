package leetCodeTest;

import java.util.*;

public class 有效地字母异位词 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println("anagram = " + anagram);
    }

    /**
     * 如果两个字符串互为异位词的话，则两个字符串中所含元素数相同，使用使用hash表记录元素数，
     * 比对两个字符串中元素数是否相等，如果不相等就返回false。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] ch = new int[26];
        int i;
        for (i=0;i<s.length();i++){
            ch[s.charAt(i) - 'a']++;
        }
        for (i=0;i<t.length();i++){
            if (ch[t.charAt(i) - 'a'] == 0)
                return false;
            ch[t.charAt(i) - 'a']--;
        }
        return true;
    }
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//        Map<Character,Integer> getmap = getmap(s);
//        Map<Character, Integer> getmap1 = getmap(t);
//        int i;
//        for (i=0;i<t.length();i++){
//            if (!getmap.containsKey(t.charAt(i))){
//                return false;
//            } else {
//                Integer integer = getmap.get(t.charAt(i));
//                Integer integer1 = getmap1.get(t.charAt(i));
//                if (!integer.equals(integer1)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static Map<Character,Integer> getmap(String a){
//        int i;
//        Map<Character,Integer> res = new HashMap();
//        for (i=0;i<a.length();i++){
//            if (res.containsKey(a.charAt(i))){
//                Integer integer = res.get(a.charAt(i));
//                res.put(a.charAt(i),++integer);
//            }else {
//                res.put(a.charAt(i),1);
//            }
//        }
//        return res;
//    }
}

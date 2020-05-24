package leetCodeTest;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        String s = "aa";
        char c = firstUniqChar(s);
        System.out.println("c = " + c);
    }
    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] chars = s.toCharArray();
        HashSet<Character> hashMap = new HashSet<>();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!hashMap.contains(chars[i]) && !deque.contains(chars[i])){
                deque.addFirst(chars[i]);
            } else if (deque.contains(chars[i])){
                hashMap.add(chars[i]);
                deque.remove(chars[i]);
            }
        }
        return deque.size() == 0?' ':deque.pollLast();
    }
}

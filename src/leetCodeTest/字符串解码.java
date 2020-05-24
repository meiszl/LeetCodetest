package leetCodeTest;

import java.util.Deque;
import java.util.LinkedList;

public class 字符串解码 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = decodeString(s);
        System.out.println("s1 = " + s1);
    }
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        int multi = 0;
        Deque<Integer> deque_multi = new LinkedList<>();
        Deque<String> deque_res = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '['){
                deque_multi.addFirst(multi);
                deque_res.addFirst(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if (aChar == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = deque_multi.pollFirst();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(deque_res.pollFirst() + tmp);
            }else if (aChar >= '0' && aChar <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(aChar));
            else
                res.append(aChar);
        }
        return res.toString();
    }
}

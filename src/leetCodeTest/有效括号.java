package leetCodeTest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 有效括号 {
    public static void main(String[] args) {
        String s = "";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (char aChar : chars) {
            switch (aChar){
                case '(':
                case '[':
                case '{':
                    deque.addFirst(aChar);
                    break;
                case ')':
                    if (deque.size() == 0)
                        return false;
                    if (deque.peekFirst() != '(')
                        return false;
                    else
                        deque.removeFirst();
                    break;
                case '}':
                    if (deque.size() == 0)
                        return false;
                    if (deque.peekFirst() != '{')
                        return false;
                    else
                        deque.removeFirst();
                    break;
                case ']':
                    if (deque.size() == 0)
                        return false;
                    if (deque.peekFirst() != '[')
                        return false;
                    else
                        deque.removeFirst();
                    break;
            }
        }
        return deque.size() == 0;
    }
}

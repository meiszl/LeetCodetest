package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class aiqiyitest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean valid = isValid(s);
        if (valid){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
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

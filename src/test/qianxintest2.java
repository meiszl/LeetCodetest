package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class qianxintest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] s = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("undo")&&!s[i].equals("redo")){
            }else if (i != 0 && s[i].equals("undo")){
                int te = i;
                while (deque.contains(s[te]) && s[te].equals("undo")){
                    te--;
                }
                deque.addFirst(te);
            }else if (i != 0 && s[i].equals("redo")){
                deque.pollFirst();
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (!deque.contains(i)&&!s[i].equals("undo")&&!s[i].equals("redo")){
                if (i != s.length-1){
                    stringBuffer.append(s[i] + " ");
                }else {
                    stringBuffer.append(s[i]);
                }
            }

        }
        System.out.println(stringBuffer.toString());
    }
}
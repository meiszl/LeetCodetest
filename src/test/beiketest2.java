package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class beiketest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int count = Integer.MIN_VALUE;
        for (int i = 1; i <= n/2; i++) {
            String substring = s.substring(0,i);
            String substring1 = s.substring(i, 2 * i);
            if (substring.equals(substring1)){
                count = Math.max(count,i);
            }
        }
        if (count != Integer.MIN_VALUE)
            System.out.println(s.length() - count + 1);
        else
            System.out.println(s.length());
    }
}

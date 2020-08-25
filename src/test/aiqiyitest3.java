package test;

import java.util.HashSet;
import java.util.Scanner;

public class aiqiyitest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findWay(s));
    }
    public static String findWay(String s){
        HashSet<String> hashSet = new HashSet<>();
        int m = 0, n = 0;
        hashSet.add(m + "," + n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = 0,y = 0;
            if (c == 'E'){
                x = m + 1;
                y = n;
            }
            if (c == 'N'){
                x = m;
                y = n + 1;
            }
            if (c == 'S'){
                x = m;
                y = n - 1;
            }
            if (c == 'W'){
                x = m - 1;
                y = n;
            }
            if (hashSet.contains(x + "," + y))
                return "True";
            else {
                hashSet.add(x + "," + y);
                m = x;
                n = y;
            }
        }
        return "False";
    }
}

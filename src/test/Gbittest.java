package test;

import java.util.Arrays;
import java.util.Scanner;

public class Gbittest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        boolean contains = s1[0].contains(s1[1]);
        if (!contains){
            System.out.println(-1);
            return;
        }
        boolean contains1 = s1[0].contains(s1[2]);
        if (!contains1){
            System.out.println(-1);
            return;
        }
        s1[0] = s1[0].toLowerCase();
        String s2 = s1[1];
        String s3 = s1[2];
        int[] s2num = new int[64];
        int[] s3num = new int[64];
        char c = s2.toLowerCase().charAt(0);
        char c1 = s3.toLowerCase().charAt(0);
        for (int i = 0; i < s2num.length&&i<s1[0].length(); i++) {
            if (s1[0].charAt(i) == c){
                s2num[i] = 1;
            }
            if (s1[0].charAt(i) == c1){
                s3num[i] = 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s2num.length; i++) {
            for (int j = 0; j < s3num.length; j++) {
                if (s2num[i] == 1 && s3num[j] == 1){
                    max = Math.max(Math.abs(i-j),max);
                }
            }
        }
        System.out.println(max);
    }
}

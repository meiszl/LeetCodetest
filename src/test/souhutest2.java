package test;

import java.util.Arrays;
import java.util.Scanner;

public class souhutest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = sc.nextInt();
        int[] build = new int[2*n];
        for (int i = 0; i < n; i++) {
            build[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(build));
    }
}

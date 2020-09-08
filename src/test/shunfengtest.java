package test;

import java.util.Scanner;

public class shunfengtest  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int coun = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j+i < n; j++) {
                int vama = 0;
                for (int l = j; l < j + i; l++) {
                    vama += a[l];
                }
                if (vama*vama > max){
                    max = vama*vama;
                    coun = i;
                }
            }
        }
        System.out.print(max + " " + coun);
    }
}

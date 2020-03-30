package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        int[] a = new int[n];
        int[] sum = new int[n];
        for (i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        if (n == 1){
            System.out.println(0);
            return;
        }
        for (i=0;i<a.length;i++){
            for (j=i;j<sum.length;j++){
                if (j!=0)
                if (a[j] % j == 0)
                    sum[j]++;
            }
        }
        int count = 0;
        for (i=0;i<sum.length;i++){
            count += sum[i];
        }
        System.out.println(count);
    }
}

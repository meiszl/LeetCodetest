package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class zijieMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i,j;
        int[] a = new int[n];
        int[] b = new int[m];
        for (i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for (i=0;i<m;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (j=0;j<b.length;j++){
            int temp = 0;
            for (i=0;i<a.length;i++){
                if (b[j] >= a[i]){
                    temp = a[i];
                }
            }
            b[j] = b[j] - temp;
        }
        int count=0;
        for (i=0;i<b.length;i++){
            count += b[i];
        }
        System.out.println(count);
    }
}

package test;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int i,j;
        int[] a = new int[N];
        for (i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        double p0 = p/q;
        int[] b = new int[N];
        int sum = 0;
        for (i=0;i<a.length;i++){
            for (j=i;j<b.length;j++){
                b[j]+= a[j];
                sum++;
            }
        }
        int count = 0;
        for (i=0;i<b.length;i++){
            count += b[i];
        }
        System.out.println((count*2/(sum + 2))%998244353);
    }
}

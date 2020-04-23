package test;

import java.util.Scanner;

public class duxiaomanTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] contr = new int[n];
        int i;
        for (i=0;i<n;i++){
            contr[i] = sc.nextInt();
        }
        if (n == 0 || contr.length == 0 || contr == null){
            System.out.println(0);
            return;
        }
        int[] sum = new int[n];
        for (i=1;i<n;i++){
            sum[i] = 10001;
        }
        sum[0] = 0;
        int count = 0;
        for (i=0;i<n;i++){
            if (contr[i] > 1){
                sum[contr[i] - 2] = Math.min(sum[contr[i] - 2],sum[i] + b + a);
            }
            if (contr[i] < n){
                sum[contr[i]] = Math.min(sum[contr[i]],sum[i] + c + a);
            }
            sum[contr[i]-1] = Math.min(sum[contr[i]-1],sum[i] + a);
        }
        System.out.println(sum[sum.length - 1]);
    }
}

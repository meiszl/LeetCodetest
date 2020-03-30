package test;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        int[] a = new int[n];
        for (i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        double pi = Math.PI;
        double[] sum = new double[n];
        double sum1 = 0;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5);
        for (i=0;i<n;i++){
             sum[i] = (a[i]*a[i])*pi;
        }
        for (i=0;i<n;i++){
            if (i==0)
                sum1 += sum[i];
            if (i!=0)
            if (i%2 == 0){
                sum1 += sum[i] - sum[i-1];
            }
        }
        sum1 = Double.parseDouble(nf.format((sum1)));
        System.out.println(sum1);
    }
}

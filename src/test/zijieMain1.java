package test;

import java.util.Scanner;

public class zijieMain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0 && n==1)
            System.out.println(0);
        int i,j,count = 0;
        int[] len = new int[n];
        for (i=0;i<n;i++){
            len[i] = sc.nextInt();
        }
        for (i=len.length-1;i>0;i--){
            while (len[i-1] > len[i]){
                if (i != 1)
                    len[i-1] = len[i-1] - Math.min(len[i-2],len[i]);
                else
                    len[i-1] = len[i-1] - len[i];
             count++;
            }
        }
        System.out.println(count);
    }
}

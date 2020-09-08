package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int i,j,k;
        int[][] sum = new int[K][N];
        int[] a = new int[N];
        for (i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        if (N == 1)
        {
            System.out.println(N*K);
        }
        for (i=0;i<K;i++){
            for (j = 0;j<N;j++){
                if (i==0)
                    for (k=0;k<j+1;k++)
                        sum[i][j] += a[k];
                else
                    for (k=0;k<j +1;k++)
                    sum[i][j] += sum[i-1][k];
            }
        }
        System.out.println(sum[K-1][N-1]%9824353);
    }
}

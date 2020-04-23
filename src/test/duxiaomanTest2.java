package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class duxiaomanTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i1 = sc.nextInt();
        int j1 = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int i,j;
        int[][] res= new int[i1][j1];
        for (i=0;i<i1;i++){
            for (j=0;j<j1;j++){
                res[i][j] = (i+1)*(j+1)%10;
            }
        }
        int deres = 0;
        for (i=0;i<i1 - m + 1;i++){
            for (j=0;j<j1 - n + 1;j++){
                int temp = 0;
                for (int k=i;k<m;k++){
                    for (int l = j;l<n;l++){
                        if (res[k][l] >= temp)
                            temp = res[k][l];
                    }
                }
                deres += temp;
            }
        }
        System.out.println(deres);
    }
}

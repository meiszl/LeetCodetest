package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class xiechengtest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int E0 = sc.nextInt();
        int X = sc.nextInt();
        int L = sc.nextInt();
        int[][] railway = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                railway[i][j] = sc.nextInt();
            }
        }
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[]{0,0});
        int[][] dp = new int[M][N];
        while (!deque.isEmpty()){
            int[] ints = deque.pollLast();
            int x = ints[0];
            int y = ints[1];
            int min = Integer.MAX_VALUE;
            if (x+1 <= M-1&& railway[x+1][y] < min){
                x = x+1;
                min = railway[x][y];
            }
            if (x-1 > 0&& railway[x-1][y] < min){
                x = x-1;
                min = railway[x][y];
            }
            if (x+1 <= M-1&& railway[x+1][y] < min){
                x = x+1;
                min = railway[x][y];
            }
            if (x+1 <= M-1&& railway[x+1][y] < min){
                x = x+1;
                min = railway[x][y];
            }
        }
    }
}

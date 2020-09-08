package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class beiketest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        long count = 0;
        int temm = m;
        for (int i = 0; i < n; i++) {
            if (i == 0){
                count += temm;
                temm--;
                continue;
            }
            for (int j = 0; j < m; j++) {
                int temp = temm < m-k?temm:m-k;

            }
        }
    }
}

package test;

import java.util.ArrayList;
import java.util.List;

public class find {
    public static void main(String[] args) {
        List<List<Integer>> res = res(11);
        System.out.println("res = " + res);
    }
    private static List<List<Integer>> list;
    public static List<List<Integer>> res(int n){
        list = new ArrayList();
        List<Integer> list1 = new ArrayList();
        int f[] = new int[n + 1];
        for (int i = 6; i <= n; i++) {
            int min = 1000;
            for (int j = 1; j <= i / 2; j++) {
                if (min > (f[j] + f[i - j])) {
                    min = f[j] + f[i - j];
                }
            }
            f[i] = min;
        }
        System.out.println("f[n-1] = " + f[n - 1]);
        return list;
    }
}

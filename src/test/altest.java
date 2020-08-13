package test;

import java.util.ArrayList;
import java.util.Scanner;

public class altest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                arr.add(in.nextInt());
            }
            nums.add(arr);
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> list = nums.get(i);
            ArrayList<Integer> re = new ArrayList<>();
            if (list.get(0) / list.get(1) <= 3) {
                re.add(-1);
                res.add(re);
                continue;

            }
            for (i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1) {
                        System.out.print(res.get(i).get(j) + " ");
                    } else {
                        System.out.println(res.get(i).get(j));
                    }
                }
            }
        }
    }
}

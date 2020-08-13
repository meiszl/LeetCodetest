package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class altest2 {
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
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i).get(0); j < nums.get(i).get(1); j++) {
                int temp = nums.get(i).get(0);
                List<Integer> list = new ArrayList<>();
                while (temp != 0){
                    list.add(temp%10);
                    temp = temp/10;
                }

            }
        }
    }

}

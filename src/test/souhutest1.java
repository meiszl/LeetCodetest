package test;

import java.util.Arrays;
import java.util.Scanner;

public class souhutest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        if (ints[0] == 0&& ints[1] == 0&& ints[2] == 0){
            System.out.println(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(ints[i],min);
        }
        int res = min;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            ints[i] = ints[i] - min;
        }
        min = Integer.MAX_VALUE;
        int fin = 0;
        for (int i = 0; i < 3; i++) {
            if (ints[i] == 0){
                fin++;
                continue;
            }
            count = Math.abs(count - ints[i]);
            min = Math.min(min,ints[i]);
        }
        if (fin == 1){
            if (min%2 == 0)
                res += min - 1;
            else
                res += min - 2;
            res += count/4;
            res = res < 0? 0:res;
        }else if (fin == 2){
            res += count/4;
        }
        System.out.println(res);

    }
}

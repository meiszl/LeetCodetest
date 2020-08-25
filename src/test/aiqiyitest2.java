package test;

import java.util.Scanner;

public class aiqiyitest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(findZ(m));
    }
    public static int findZ(int m){
        if (m == 0) return 0;
        int Countnums = 0;
        while (m >= 0){
            Countnums += m/5;
            m=m/5;
        }
        return Countnums;
    }
}

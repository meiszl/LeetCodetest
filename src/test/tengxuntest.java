package test;

import java.util.Scanner;

public class tengxuntest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == k && k == 1){
            System.out.println("");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i == k-1) {
                sc.nextInt();
                continue;
            }
            if (i != n-1)
                if (i == n-2 && k == n)
                    System.out.print(sc.nextInt());
                else
                    System.out.print(sc.nextInt() + " ");
            else
                System.out.print(sc.nextInt());
        }
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        sc.nextLine();
//        String s = sc.nextLine();
//        StringBuilder stringBuffer = new StringBuilder(s);
//        stringBuffer.deleteCharAt(2*k-2);
//        stringBuffer.deleteCharAt(2*k-3);
//        System.out.println(stringBuffer.toString());
    }

}

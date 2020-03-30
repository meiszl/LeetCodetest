package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        boolean flag = false;
        if (n.charAt(0) == '-')
            flag = true;
        int i;
        int[] a = new int[9];
        for (i=0;i<9;i++){
            a[i] = sc.nextInt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (flag)
        {
            for (i=1;i<n.length();i++){
                int i1 = n.charAt(i) - 49;
                stringBuilder.append(a[i1]);
            }
            System.out.println('-' + stringBuilder.toString());
        }
        else{
            for (i=0;i<n.length();i++){
                int i1 = n.charAt(i) - 49;
                stringBuilder.append(a[i1]);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}

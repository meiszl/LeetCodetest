package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class beiketest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String[]> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            list.add(s1);
        }
        list.forEach(o -> {
            String compa = compa(o);
            System.out.println(compa);
        });
    }
    private static String compa(String[] a){
        int counleft = 0;
        int counright = 0;
        if (a[0].equals("S")&&a[2].equals("J")){
            counleft++;
        }
        if (a[0].equals("J")&&a[2].equals("B")){
            counleft++;
        }
        if (a[0].equals("B")&&a[2].equals("S")){
            counleft++;
        }
        if (a[0].equals("S")&&a[3].equals("J")){
            counleft++;
        }
        if (a[0].equals("J")&&a[3].equals("B")){
            counleft++;
        }
        if (a[0].equals("B")&&a[3].equals("S")){
            counleft++;
        }


        if (a[1].equals("S")&&a[2].equals("J")){
            counright++;
        }
        if (a[1].equals("J")&&a[2].equals("B")){
            counright++;
        }
        if (a[1].equals("B")&&a[2].equals("S")){
            counright++;
        }
        if (a[1].equals("S")&&a[3].equals("J")){
            counright++;
        }
        if (a[1].equals("J")&&a[3].equals("B")){
            counright++;
        }
        if (a[1].equals("B")&&a[3].equals("S")){
            counright++;
        }
        String res = new String();
        if (counleft > counright){
            res = "left";
        }else if (counright > counleft){
            res = "right";
        }else {
            res = "same";
        }
        return res;
    }
}

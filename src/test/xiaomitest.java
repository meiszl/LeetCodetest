package test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class xiaomitest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> r = new ArrayList<>();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            int a = 0;
            int a_1 = 0;
            int a_2 = 0;
            int a_3 = 0;
            String s2 = s1[i];
            char[] chars = s2.toCharArray();
            if (chars.length < 8|| chars.length > 120){
                r.add(1);
                continue;
            }
            for (char aChar : chars) {
                if (Character.isDigit(aChar)){
                    a = 1;
                }else if (Character.isLowerCase(aChar)){
                    a_1 = 1;
                }else if (Character.isUpperCase(aChar)){
                    a_2 = 1;
                }else {
                    a_3 = 1;
                }
            }
            int sum = a + a_1 + a_2 + a_3;
            if (sum == 4){
                r.add(0);
            }else {
                r.add(2);
            }
        }
        r.forEach(o -> System.out.println(o));
    }
}

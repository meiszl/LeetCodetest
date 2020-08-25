package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class meituantest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            flag = false;
            String s = sc.nextLine();
            if (s.length() < 2){
                System.out.println("Wrong");
                continue;
            }
            if (s.charAt(0) < 'A'||s.charAt(0) > 'Z'){
                System.out.println("Wrong");
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z')||
                        (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')||
                        (s.charAt(j) >= '0' && s.charAt(j) <= '9'))){
                    System.out.println("Wrong");
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    count++;
                    break;
                }
            }
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')){
                    count++;
                    break;
                }
            }
            if (count == 2)
                System.out.println("Accept");
            else {
                System.out.println("Wrong");
            }
        }
    }
}

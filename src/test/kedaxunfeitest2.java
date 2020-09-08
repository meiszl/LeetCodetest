package test;

import java.util.Scanner;

public class kedaxunfeitest2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        s = s.replaceAll("_", " ");
//        s = s.trim();
//        String[] s1 = s.split(" ");
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < s1.length; i++) {
//            if (s1[i].length() == 0) continue;
//            ans.append(s1[i]).append(" ");
//        }
//        if (ans.length() > 0) ans.deleteCharAt(ans.length() - 1);
//        String res = ans.toString().replaceAll(" ","_");
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replace('_', ' ').trim();
        StringBuffer sb = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '&&s.charAt(i+1) !=' '&&flag==1){
                sb.append(' ');
                flag = 0;
            }else if (s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                flag = 1;
            }
        }
        System.out.println(sb.toString().replaceAll(" ","_"));
    }
}

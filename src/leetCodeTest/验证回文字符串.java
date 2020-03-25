package leetCodeTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 验证回文字符串 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println("palindrome = " + palindrome);
    }
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() ==1)
            return true;
        s = s.toLowerCase();
        int i;
        StringBuilder str = new StringBuilder();
        for (i=0;i<s.length();i++){
            if ((s.charAt(i) >= 48 && s.charAt(i) <=57) || (s.charAt(i) >= 97 && s.charAt(i) <=122))
                str.append(s.charAt(i));
        }
        String s1 = str.toString();
        for (i=0;i<s1.length()/2;i++){
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1))
                return false;
        }
        return true;
    }
}

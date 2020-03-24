package leetCodeTest;

import java.util.Arrays;

public class 反转字符串 {
    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    /**
     * 普通的数组替换数值即可
     * @param s
     */
    public static void reverseString(char[] s) {
        char temp;
        int i;
        for (i=0;i<s.length/2;i++){
            temp =  s[i];
            s[i] = s[s.length - i - 1];
            s[s.length-i-1] = temp;
        }
    }
}

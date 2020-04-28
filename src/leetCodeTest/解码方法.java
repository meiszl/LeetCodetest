package leetCodeTest;


import java.util.Arrays;

public class 解码方法 {
    public static void main(String[] args) {
        String s = "110";
        int i = numDecodings(s);
        System.out.println("i = " + i);
    }
    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        char[] sc = s.toCharArray();
        int[] sum = new int[s.length() + 1];
        sum[0] = 1;
        sum[1] = 1;
        for (int i = 2; i <= sc.length; i++) {
            int n = (sc[i - 2] - '0') * 10 + (sc[i - 1] - '0');
            if (sc[i - 1] == '0' && sc[i-2]=='0')
                return 0;
            if (sc[i - 1] == '0'){
                if (n>26) return 0;
                sum[i] = sum[i-2];
            }else if (sc[i-2] == '0'){
                sum[i] = sum[i-1];
            }else if (n>26){
                sum[i] = sum[i-1];
            }else {
                sum[i] = sum[i-1] + sum[i-2];
            }
        }
        return sum[s.length()];
    }
}

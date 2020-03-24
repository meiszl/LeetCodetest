package leetCodeTest;

import java.util.Arrays;

public class 整数反转 {
    public static void main(String[] args) {
        int x = -2147483648;
        int reverse = reverse(x);
        System.out.println("reverse = " + reverse);
    }

    /**
     * 使用Long来存储x保证x不会出现溢出的情况，然后判断x是否小于0.保证x为正数使用flag记录x的正负情况。
     * for循环反转x，然后通过flag来判断x的正负情况，使用Double来保证字符串转化的时候不出现溢出情况，
     * 最后判断结果是否为int范围内的数，如果是的话返回结果，否则返回0.
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean flag;
        long ab = Long.parseLong(String.valueOf(x));
        if (ab<0){
            flag = true;
            ab = -ab;
        }else {
            flag = false;
        }
        String[] s =Long.toString(ab).split("");
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        for (i=s.length-1;i>=0;i--){
            stringBuilder.append(s[i]);
        }

        double i1 = Double.parseDouble(stringBuilder.toString());
        if (flag)
            i1 = -i1;//[−231,  231 − 1]
        if (i1 < Integer.MIN_VALUE || i1 > Integer.MAX_VALUE)
            return 0;
        return (int) i1;
    }
}

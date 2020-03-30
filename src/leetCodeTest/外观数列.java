package leetCodeTest;

import java.util.Arrays;

public class 外观数列 {
    public static void main(String[] args) {
        int n = 4;
        String s = countAndSay(n);
        System.out.println("s = " + s);
    }

    /**
     * 使用线性规划算法求出到n-1为止的所有外观数列，然后返回对应位置的数字。
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        //定义与n长度相同的用于存放外观数列的String数组
        String[] s = new String[n];
        int i,j;
        s[0] = "1";
        //定义在运算时构造当前位置数列的StringBuilder类
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars;
        //用于计算上一个数列中每个字符出现的次数
        int count;
        for (i=1;i<s.length;i++){
            count = 1;
            //循环提取每一个字符数组
            chars = s[i-1].toCharArray();
            stringBuilder = new StringBuilder();
            //遍历字符数组统计每一个字符出现的次数
            for (j=0;j<chars.length-1;j++){
                if (chars[j] == chars[j+1]){
                    count++;
                    continue;
                }
                stringBuilder.append(String.valueOf(count)).append(chars[j]);
                count = 1;
            }
            stringBuilder.append(String.valueOf(count)).append(chars[chars.length-1]);
            s[i] = stringBuilder.toString();
        }
        System.out.println(Arrays.toString(s));
        return s[n-1];
    }
}

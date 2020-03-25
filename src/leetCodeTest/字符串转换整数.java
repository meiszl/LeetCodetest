package leetCodeTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 字符串转换整数 {
    public static void main(String[] args) {
        String str = "3.14159";
        int i = myAtoi(str);
        System.out.println("i = " + i);
    }

    /**
     * 使用传统方法if判断切分得出结果
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if(str==null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while(i<n && str.charAt(i)==' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if(i==n) {
            return 0;
        }
        //第二步，判断正负号
        if(str.charAt(i)=='-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            ++i;
        }
        //第三步，循环判断字符是否在 0~9之间
        while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i)-48;
            //判断是否大于 最大32位整数
            if(!is_negative &&(res>214748364 ||(res==214748364 && tmp>=7))) {
                return 2147483647;
            }
            //判断是否小于 最小32位整数
            if(is_negative &&(-res<-214748364 || (-res==-214748364 && tmp>=8))) {
                return -2147483648;
            }
            res = res*10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if(is_negative) {
            return -res;
        }
        return res;
    }

    /**
     * 使用正则表达式切分字符串然后返回对应的整数。
     * @param str
     * @return
     */
//    public static int myAtoi(String str) {
//        str = str.trim();
//        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
//        Matcher m = p.matcher(str);
//        int value = 0;
//        //使用正则表达式的时候必须先执行find方法使用matcher从字符串中找到对应匹配才能进行接下来的切分逻辑
//        if (m.find()){
//            //字符串转整数，溢出
//            try {
//                value = Integer.parseInt(str.substring(m.start(), m.end()));
//            } catch (Exception e){
//                //由于有的字符串"42"没有正号，所以我们判断'-'
//                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
//            }
//        }
//        return value;
//    }
}

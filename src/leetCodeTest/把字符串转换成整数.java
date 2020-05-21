package leetCodeTest;

public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "-91283472332 fa";
        int i = strToInt(str);
        System.out.println("i = " + i);
    }
    public static int strToInt(String str) {
        if(str == null ||str.length() == 0) return 0;
        str = str.trim();
        char[] chars = str.toCharArray();
        long res = 0;
        boolean flag = false;
        boolean set = true;
        for (int i = 0; i < chars.length; i++) {
            if (set && res == 0 && chars[i] == '+') {
                set = false;
                continue;
            }
            if (set && chars[i] == '-'){
                flag = true;
                set = false;
                continue;
            }
            if ((chars[i] < '0'|| chars[i] > '9')){
                return flag? (int)-res:(int)res;
            }else {
                set = false;
                if ((!flag&&res*10 + chars[i] - '0' >= Integer.MAX_VALUE) || (flag&&-(res*10 + chars[i] - '0') <= Integer.MIN_VALUE)) {
                    return flag? Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                res *= 10;
                res += chars[i] - '0';
            }
        }
        return flag? (int)-res:(int)res;
    }
}

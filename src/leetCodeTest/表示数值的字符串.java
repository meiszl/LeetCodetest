package leetCodeTest;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        String s = "+E3";
        boolean number = isNumber(s);
        System.out.println("number = " + number);
    }
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if(s.length() == 0)
            return false;
        char[] chars = s.toCharArray();
        int count = 0;
        int point = 0;
        int index = 0;
        if (chars[0] == '-' || chars[0] == '+')
            index++;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '-' || chars[i] == '+'){
                if (chars[i-1] != 'e'&&chars[i-1] != 'E')
                    return false;
                if (i == chars.length-1)
                    return false;
                continue;
            }
            if (chars[i] == 'e' || chars[i] == 'E'){
                count++;
                if (count > 1)
                    return false;
                if (i==0||((chars[i-1]<'0'||chars[i-1]>'9')&&chars[i-1] != '.')||i==chars.length-1)
                    return false;
                if (chars[i] == 'E' && chars[i-1] == '.')
                    return false;
                point++;
                continue;
            }
            if (chars[i] == '.'){
                point++;
                if (point>1)
                    return false;
                if (i==0 && i == chars.length-1)
                    return false;
                if((i==0 && i != chars.length-1)&&(chars[i+1]<'0'||chars[i+1]>'9'))
                    return false;
                if (i == chars.length - 1 && (chars[i-1]<'0'||chars[i-1]>'9'))
                    return false;
            }
            if ((chars[i] < '0' || chars[i] > '9')&& chars[i] != 'e'&&chars[i] != 'E'&&chars[i] != '.')
                return false;
        }
        return true;
    }
}

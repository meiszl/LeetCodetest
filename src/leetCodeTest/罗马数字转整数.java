package leetCodeTest;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int i = romanToInt(s);
        System.out.println("i = " + i);
    }
    public static int romanToInt(String s) {
        int ans = 0;
        int num = findNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num1 = findNum(s.charAt(i));
            if (num1 > num){
                ans += -num;
            }else {
                ans += num;
            }
            num = num1;
        }
        ans += num;
        return ans;
    }
    public static int findNum(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
